package net.expaw.springboot.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.expaw.springboot.dto.User;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class JsonKafkaProducer {

    private final KafkaTemplate<String, User> kafkaTemplate;

    public void sendMessage(User data){
    log.info(String.format("Message sent -> %s",data.toString()));
        Message<User> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC,"expaw_json")
                .build();

        kafkaTemplate.send(message);
    }

}
