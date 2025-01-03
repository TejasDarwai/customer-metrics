package customer_metrics.customer_metrics.service;

import customer_metrics.customer_metrics.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    List<User> getAllUser();

    User getUser(String userId);

    User loginUser(User user);
}
