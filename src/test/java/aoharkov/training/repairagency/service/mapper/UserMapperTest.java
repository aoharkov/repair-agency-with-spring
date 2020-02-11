package aoharkov.training.repairagency.service.mapper;

import aoharkov.training.repairagency.TestObjectsInitializer;
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
        entity = TestObjectsInitializer.initUserEntity();
        item = TestObjectsInitializer.initUser();
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