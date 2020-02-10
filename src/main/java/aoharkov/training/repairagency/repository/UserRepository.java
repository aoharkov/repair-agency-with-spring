package aoharkov.training.repairagency.repository;

import aoharkov.training.repairagency.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    UserEntity findByEmail(String email);
}
