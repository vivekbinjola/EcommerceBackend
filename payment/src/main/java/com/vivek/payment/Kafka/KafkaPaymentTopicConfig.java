package com.vivek.payment.Kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.stereotype.Service;

@Configuration
public class KafkaPaymentTopicConfig {

    @Bean
    public NewTopic paymentTopic(){
        return TopicBuilder.name("payment-topic")
                .build();
    }
}
