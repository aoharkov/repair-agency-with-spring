package aoharkov.training.repairagency.service;

import aoharkov.training.repairagency.domain.User;
import org.springframework.data.domain.Page;

public interface UserService {

    User login(String email, String password);

    void register(User user);

    Page<User> findAllUsers(int page, int itemsPerPage);

}
