package aoharkov.training.repairagency.service.mapper;

import aoharkov.training.repairagency.TestObjectsInitializer;
import aoharkov.training.repairagency.domain.Request;
import aoharkov.training.repairagency.entity.RequestEntity;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RequestMapperTest {
    private static Mapper<RequestEntity, Request> requestMapper = MapperContext.getRequestMapper();
    private RequestEntity requestEntity;
    private Request request;

    @Before
    public void setUp() {
        requestEntity = TestObjectsInitializer.initRequestEntity();
        request = TestObjectsInitializer.initRequest();
    }

    @Test
    public void mapDomainToEntityShouldMapCorrectly() {
        assertEquals(requestEntity, requestMapper.mapDomainToEntity(request));
    }

    @Test
    public void mapEntityToDomainShouldMapCorrectly() {
        assertEquals(request, requestMapper.mapEntityToDomain(requestEntity));
    }
}