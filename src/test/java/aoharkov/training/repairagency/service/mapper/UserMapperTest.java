package aoharkov.training.repairagency.service.mapper;

import aoharkov.training.repairagency.TestObjectsInitializer;
import aoharkov.training.repairagency.domain.User;
import aoharkov.training.repairagency.entity.UserEntity;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserMapperTest {
    private static Mapper<UserEntity, User> userMapper = MapperContext.getUserMapper();
    private UserEntity userEntity;
    private User user;

    @Before
    public void setUp() {
        userEntity = TestObjectsInitializer.initUserEntity(1);
        user = TestObjectsInitializer.initUser(1);
    }

    @Test
    public void mapDomainToEntityShouldMapCorrectly() {
        assertEquals(userEntity, userMapper.mapDomainToEntity(user));
    }

    @Test
    public void mapEntityToDomainShouldMapCorrectly() {
        assertEquals(user, userMapper.mapEntityToDomain(userEntity));
    }
}