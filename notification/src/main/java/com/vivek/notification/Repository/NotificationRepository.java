package com.vivek.notification.Repository;

import com.vivek.notification.Models.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends MongoRepository< Notification, Integer> {
}
