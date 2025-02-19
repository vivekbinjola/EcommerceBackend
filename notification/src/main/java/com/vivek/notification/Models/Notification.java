package com.vivek.notification.Models;

import com.vivek.notification.Kafka.OrderConfirmation;
import com.vivek.notification.Kafka.PaymentConfirmation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Builder
@Data
@AllArgsConstructor
@Document
public class Notification {

    @Id
    private Integer id;
    private LocalDateTime notificationTime;
    private NotificationType type;
    private PaymentConfirmation paymentConfirmation;
    private OrderConfirmation orderConfirmation;
}
