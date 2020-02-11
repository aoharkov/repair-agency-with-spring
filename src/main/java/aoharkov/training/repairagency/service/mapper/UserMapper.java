package aoharkov.training.repairagency.service.mapper;

import aoharkov.training.repairagency.domain.User;
import aoharkov.training.repairagency.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements Mapper<UserEntity, User> {

    @Override
    public UserEntity mapDomainToEntity(User item) {
        return new UserEntity(
                item.getId(),
                item.getName(),
                item.getSurname(),
                item.getEmail(),
                item.getPassword(),
                item.getRole());
    }

    @Override
    public User mapEntityToDomain(UserEntity entity) {
        return User.builder()
                .id(entity.getId())
                .name(entity.getName())
                .surname(entity.getSurname())
                .email(entity.getEmail())
                .password(entity.getPassword())
                .role(entity.getRole())
                .build();
    }
}
