package aoharkov.training.repairagency.service.impl;

import aoharkov.training.repairagency.domain.Role;
import aoharkov.training.repairagency.domain.User;
import aoharkov.training.repairagency.entity.UserEntity;
import aoharkov.training.repairagency.mapper.UserMapper;
import aoharkov.training.repairagency.repository.UserRepository;
import aoharkov.training.repairagency.service.AdminService;
import aoharkov.training.repairagency.service.encoder.Encoder;
import aoharkov.training.repairagency.service.validator.Validator;

import java.util.Optional;

public class AdminServiceImpl extends UserServiceImpl implements AdminService {

    public AdminServiceImpl(Encoder encoder, Validator<User> userValidator,
                            UserRepository userRepository, UserMapper userMapper) {
        super(encoder, userValidator, userRepository, userMapper);
    }

/*    @Override
    public List<User> findAllUsers(int page, int itemsPerPage) {
        Page<UserEntity> userEntityPage = userRepository.findAll(page, itemsPerPage);
        return userEntityPage.getItems().stream()
                .map(userMapper::mapEntityToDomain)
                .collect(Collectors.toList());
    }*/

    @Override
    public void setRoleToUser(User user, Role role) {
        Optional<UserEntity> userEntity = userRepository.findById(user.getId());
        if (userEntity.isPresent()) {
            user.setRole(role);
            userRepository.save(userMapper.mapDomainToEntity(user));
        }
    }
}
