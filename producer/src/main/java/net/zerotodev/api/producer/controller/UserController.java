package net.zerotodev.api.producer.controller;

import lombok.RequiredArgsConstructor;

import net.zerotodev.api.producer.domain.User;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final KafkaTemplate<String, User> kafkaTemplate;

    private static final String TOPIC = "TOPIC-01";

    @GetMapping("/publish/{name}")
    public String postMessage(@PathVariable final String name){
        User user = new User();
        user.setId("blahblah");
        user.setName(name);
        user.setEmail(name+"@test.com");
        kafkaTemplate.send(TOPIC, user);
        return "Message Published Successfully";
    }


}
