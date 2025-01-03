package customer_metrics.customer_metrics.service.impl;

import customer_metrics.customer_metrics.entity.User;
import customer_metrics.customer_metrics.exception.UserNotFoundException;
import customer_metrics.customer_metrics.repository.UserRepository;
import customer_metrics.customer_metrics.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final String USER_LOGIN_TOPIC = "user-logged-in";
    private static final String USER_CREATED_TOPIC = "user-created";
    
    

    @Override
    public User saveUser(User user) {
        String randomUserId = UUID.randomUUID().toString();
        user.setId(randomUserId);
        User savedUser = this.userRepo.save(user);
        savedUser.setPassword("");
        kafkaTemplate.send(USER_CREATED_TOPIC, user.getEmailId());
        return savedUser;
    }

    @Override
    public List<User> getAllUser() {
        return this.userRepo.findAll();
    }

    @Override
    public User getUser(String userId) {
        return this.userRepo.findById(userId).orElseThrow(()->new UserNotFoundException("Requested User "+userId+" Not Found"));
    }

    @Override
    public User loginUser(User user) throws UserNotFoundException {
        User userToFind = this.userRepo.findByName(user.getName());
        if (userToFind != null && userToFind.getPassword().equals(user.getPassword())) {

            kafkaTemplate.send(USER_LOGIN_TOPIC, "User " + user.getEmailId());

            user.setPassword("");
            user.setName(userToFind.getName());
            user.setEmailId(user.getEmailId());
            user.setId(userToFind.getId());
            return user;
        }
        throw new UserNotFoundException("Requested User Not Found");
    }
}
