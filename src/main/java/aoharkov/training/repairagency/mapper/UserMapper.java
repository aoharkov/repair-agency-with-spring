package aoharkov.training.repairagency.mapper;

import aoharkov.training.repairagency.domain.User;
import aoharkov.training.repairagency.entity.UserEntity;

public class UserMapper implements Mapper<UserEntity, User> {

    @Override
    public UserEntity mapDomainToEntity(User item) {
        return UserEntity.builder()
                .id(item.getId())
                .name(item.getName())
                .surname(item.getSurname())
                .email(item.getEmail())
                .password(item.getPassword())
                .role(item.getRole())
                .build();
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
