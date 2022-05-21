package net.expaw.springboot.controller;

import lombok.RequiredArgsConstructor;
import net.expaw.springboot.dto.User;
import net.expaw.springboot.kafka.JsonKafkaProducer;
import net.expaw.springboot.kafka.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {

    private final JsonKafkaProducer kafkaProducer;

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user){
        kafkaProducer.sendMessage(user);
        return ResponseEntity.ok("Json message sent to kafka topic");
    }
}
