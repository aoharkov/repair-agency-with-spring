package aoharkov.training.repairagency.service.impl;

import aoharkov.training.repairagency.domain.User;
import aoharkov.training.repairagency.entity.UserEntity;
import aoharkov.training.repairagency.repository.UserRepository;
import aoharkov.training.repairagency.service.UserService;
import aoharkov.training.repairagency.service.exception.EntityAlreadyExistException;
import aoharkov.training.repairagency.service.exception.EntityNotFoundException;
import aoharkov.training.repairagency.service.exception.IncorrectPasswordException;
import aoharkov.training.repairagency.service.mapper.Mapper;
import aoharkov.training.repairagency.service.validator.Validator;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {
    private final Validator<User> userValidator;
    private final UserRepository userRepository;
    private final Mapper<UserEntity, User> userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User login(String email, String password) {
        userValidator.validateEmail(email);
        UserEntity userEntity = userRepository.findByEmail(email);
        if (userEntity != null) {
            String encryptedPassword = passwordEncoder.encode(password);
            if (encryptedPassword.equals(userEntity.getPassword())) {
                return userMapper.mapEntityToDomain(userEntity);
            } else {
                throw new IncorrectPasswordException();
            }
        }
        throw new EntityNotFoundException();
    }

    @Override
    public void register(User user) {
        userValidator.validate(user);
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new EntityAlreadyExistException();
        }
        userRepository.save(userMapper.mapDomainToEntity(user));
    }
}
