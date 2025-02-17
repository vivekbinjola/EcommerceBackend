package com.vivek.order.Kafka;

import com.vivek.order.DTO.OrderConfirmation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderProducer {

    private final KafkaTemplate<String, OrderConfirmation> kafkaTemplate;

    public void sendOrderConfirmation(OrderConfirmation orderConfirmation) {
        log.info("sending orderConfirmation");
        Message<OrderConfirmation> order = MessageBuilder.withPayload(orderConfirmation)
                .setHeader(KafkaHeaders.TOPIC ,"order-topic")
                .build();

        kafkaTemplate.send(order);
    }

}
