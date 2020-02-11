package aoharkov.training.repairagency.mapper;

import aoharkov.training.repairagency.TestObjectsInitializer;
import aoharkov.training.repairagency.domain.Request;
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
        entity = TestObjectsInitializer.initRequestEntity();
        item = TestObjectsInitializer.initRequest();
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