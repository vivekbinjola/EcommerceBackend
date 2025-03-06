package com.vivek.notification.Kafka;

import com.vivek.notification.Email.EmailService;
import com.vivek.notification.Models.Notification;
import com.vivek.notification.Repository.NotificationRepository;
import jakarta.mail.MessagingException;
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
    private final EmailService emailService;

    @KafkaListener(topics = "payment-topic")
    public void consumePaymentSuccessNotification(PaymentConfirmation paymentConfirmation) throws MessagingException {
       log.info(String.format("Consuming payment successful notification : %s ", paymentConfirmation));
        repository.save(Notification.builder()
                .notificationTime(LocalDateTime.now())
                .paymentConfirmation(paymentConfirmation)
                .type(PAYMENT_CONFIRMATION)
                .build());

//        Sending data to Mail service
        String customerName = paymentConfirmation.customerFirstname() + " "+ paymentConfirmation.customerLastname();
        emailService.sendPaymentSuccessEmail(
                paymentConfirmation.customerEmail(),
                customerName,
                paymentConfirmation.amount(),
                paymentConfirmation.orderReference()

        );
    }

    @KafkaListener(topics = "order-topic")
    public void consumeOrderSuccessNotification(OrderConfirmation  orderConfirmation) throws MessagingException {
        log.info(String.format("Consuming order successful notification : %s ", orderConfirmation));
        repository.save(Notification.builder()
                .notificationTime(LocalDateTime.now())
                .orderConfirmation(orderConfirmation)
                .type(ORDER_CONFIRMATION)
                .build());

        //        Sending data to Mail service
        String customerName = orderConfirmation.getCustomer().firstname()+ " "+ orderConfirmation.getCustomer().lastname();
        emailService.sendOrderConfirmationEmail(
                orderConfirmation.customer().email(),
                customerName,
                orderConfirmation.getTotalAmount(),
                orderConfirmation.orderReference(),
                orderConfirmation.products()

        );
    }



}
