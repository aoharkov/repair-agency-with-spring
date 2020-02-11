package aoharkov.training.repairagency.service;

import aoharkov.training.repairagency.domain.Role;
import aoharkov.training.repairagency.domain.User;
import org.springframework.data.domain.Page;

public interface AdminService {

    Page<User> findAllUsers(int page, int itemsPerPage);

    void setRoleToUser(User user, Role role);
}
