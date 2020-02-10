package aoharkov.training.repairagency.mapper;

import aoharkov.training.repairagency.domain.Request;
import aoharkov.training.repairagency.domain.User;
import aoharkov.training.repairagency.entity.RequestEntity;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RequestMapperTest {
    private static final Mapper<RequestEntity, Request> MAPPER = new RequestMapper();
    private RequestEntity entity;
    private Request item;

    @Before
    public void setUp() {
        entity = RequestEntity.builder()
                .id(1)
                .description("just do it")
                .clientId(2)
                .viewed(false)
                .accepted(false)
                .build();
        item = Request.builder()
                .id(1)
                .description("just do it")
                .client(User.builder().id(2).build())
                .viewed(false)
                .accepted(false)
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