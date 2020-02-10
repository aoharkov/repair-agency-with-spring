package aoharkov.training.repairagency.service;

import aoharkov.training.repairagency.domain.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User login(String email, String password);

    void register(User user);

}
