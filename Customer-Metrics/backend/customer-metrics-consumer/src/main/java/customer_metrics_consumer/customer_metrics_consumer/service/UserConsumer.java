package customer_metrics_consumer.customer_metrics_consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class UserConsumer {

    @Autowired
    private EmailService emailService;
    @Autowired
    private MetricsService metricsService;

    @KafkaListener(topics = "user-logged-in", groupId = "group_id_user_login")
    public void consumeUserLogin(String emailId) {
        System.out.println("Consumer received: " + emailId);
        metricsService.incrementUserLogin();
        emailService.sendLoginNotification(emailId, emailId);
    }

    @KafkaListener(topics = "user-created", groupId = "group_id_user_created")
    public void consumeUserCreation(String emailId) {
        System.out.println("Consumer received: " + emailId);
        metricsService.incrementUserCreated();
    }
}
