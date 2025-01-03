package customer_metrics_consumer.customer_metrics_consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendLoginNotification(String toEmail, String userName) {
        String eMail = extractEmail(toEmail);
        System.out.println("extracted Email is ");
        System.out.println(eMail);
        SimpleMailMessage message = new SimpleMailMessage();
        assert eMail != null;
        message.setTo(eMail);
        message.setSubject("Login Notification");
        message.setText("Hello " + userName + ",\n\nYou have successfully logged in.\n\nBest Regards,\nYour Team");
        mailSender.send(message);
    }

    public static String extractEmail(String input) {
        String emailRegex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }
}
