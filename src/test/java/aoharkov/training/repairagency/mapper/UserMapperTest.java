package aoharkov.training.repairagency.mapper;

import aoharkov.training.repairagency.domain.Role;
import aoharkov.training.repairagency.domain.User;
import aoharkov.training.repairagency.entity.UserEntity;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserMapperTest {
    private static final Mapper<UserEntity, User> MAPPER = new UserMapper();
    private UserEntity entity;
    private User item;

    @Before
    public void setUp() {
        entity = UserEntity.builder()
                .id(1)
                .name("John")
                .surname("Doe")
                .email("doe@gmail.com")
                .password("pass")
                .role(Role.CLIENT)
                .build();
        item = User.builder()
                .id(1)
                .name("John")
                .surname("Doe")
                .email("doe@gmail.com")
                .password("pass")
                .role(Role.CLIENT)
                .build();
    }

    @Test
    public void mapDomainToEntityShouldMapCorrectly() {
        assertEquals(entity, MAPPER.mapDomainToEntity(item));
    }

    @Test
    public void mapEntityToDomainShouldMapCorrectly() {
        assertEquals(item, MAPPER.mapEntityToDomain(entity));
    }
}