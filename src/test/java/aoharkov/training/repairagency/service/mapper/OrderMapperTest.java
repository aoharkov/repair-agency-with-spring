package aoharkov.training.repairagency.service.mapper;

import aoharkov.training.repairagency.TestObjectsInitializer;
import aoharkov.training.repairagency.domain.Order;
import aoharkov.training.repairagency.entity.OrderEntity;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OrderMapperTest {
    private static final Mapper<OrderEntity, Order> MAPPER = new OrderMapper();
    private OrderEntity entity;
    private Order item;

    @Before
    public void setUp() {
        entity = TestObjectsInitializer.initOrderEntity();
        item = TestObjectsInitializer.initOrder();
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