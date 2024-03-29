package net.expaw.springboot.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic expawTopic(){
        return TopicBuilder
                .name("expaw")
                .build();
    }

    @Bean
    public NewTopic expawJsonTopic(){
        return TopicBuilder
                .name("expaw_json")
                .build();
    }
}
