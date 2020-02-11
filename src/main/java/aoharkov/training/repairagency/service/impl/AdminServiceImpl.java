package aoharkov.training.repairagency.service.impl;

import aoharkov.training.repairagency.domain.Role;
import aoharkov.training.repairagency.domain.User;
import aoharkov.training.repairagency.entity.UserEntity;
import aoharkov.training.repairagency.mapper.UserMapper;
import aoharkov.training.repairagency.repository.UserRepository;
import aoharkov.training.repairagency.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AdminServiceImpl implements AdminService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public Page<User> findAllUsers(int page, int itemsPerPage) {
        Page<UserEntity> userEntityPage =
                userRepository.findAll(PageRequest.of(page, itemsPerPage));
        return userEntityPage.map(userMapper::mapEntityToDomain);
    }

    @Override
    public void setRoleToUser(User user, Role role) {
        Optional<UserEntity> userEntity = userRepository.findById(user.getId());
        if (userEntity.isPresent()) {
            user.setRole(role);
            userRepository.save(userMapper.mapDomainToEntity(user));
        }
    }
}
