package com.vivek.notification.Kafka;

import com.vivek.notification.Models.Notification;
import com.vivek.notification.Repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;

import static com.vivek.notification.Models.NotificationType.ORDER_CONFIRMATION;
import static com.vivek.notification.Models.NotificationType.PAYMENT_CONFIRMATION;

@Slf4j
@RequiredArgsConstructor
@Service
public class NotificationConsumer {

    private final NotificationRepository repository;

    @KafkaListener(topics = "payment-topic")
    public void consumePaymentSuccessNotification(PaymentConfirmation paymentConfirmation){
       log.info(String.format("Consuming payment successful notification : %s ", paymentConfirmation));
        repository.save(Notification.builder()
                .notificationTime(LocalDateTime.now())
                .paymentConfirmation(paymentConfirmation)
                .type(PAYMENT_CONFIRMATION)
                .build());
    }

    @KafkaListener(topics = "order-topic")
    public void consumeOrderSuccessNotification(OrderConfirmation  orderConfirmation){
        log.info(String.format("Consuming order successful notification : %s ", orderConfirmation));
        repository.save(Notification.builder()
                .notificationTime(LocalDateTime.now())
                .orderConfirmation(orderConfirmation)
                .type(ORDER_CONFIRMATION)
                .build());
    }

}
