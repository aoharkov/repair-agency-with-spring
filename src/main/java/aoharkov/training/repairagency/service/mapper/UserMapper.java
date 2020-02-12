package aoharkov.training.repairagency.service.mapper;

import aoharkov.training.repairagency.domain.User;
import aoharkov.training.repairagency.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component("userMapper")
public class UserMapper implements Mapper<UserEntity, User> {

    @Override
    public UserEntity mapDomainToEntity(User user) {
        if (user == null) {
            return null;
        }
        return new UserEntity(
                user.getId(),
                user.getName(),
                user.getSurname(),
                user.getEmail(),
                user.getPassword(),
                user.getRole());
    }

    @Override
    public User mapEntityToDomain(UserEntity userEntity) {
        if (userEntity == null) {
            return null;
        }
        return User.builder()
                .id(userEntity.getId())
                .name(userEntity.getName())
                .surname(userEntity.getSurname())
                .email(userEntity.getEmail())
                .password(userEntity.getPassword())
                .role(userEntity.getRole())
                .build();
    }
}
