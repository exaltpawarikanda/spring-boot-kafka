package net.expaw.springboot.kafka;

import lombok.extern.slf4j.Slf4j;
import net.expaw.springboot.dto.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class JsonKafkaConsumer {

    @KafkaListener(topics = "expaw_json", groupId = "myGroup")
    public void consume(User user) {
        log.info(String.format("Message received -> %s", user.toString()));
    }
}
