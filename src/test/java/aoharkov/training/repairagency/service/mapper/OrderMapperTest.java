package aoharkov.training.repairagency.service.mapper;

import aoharkov.training.repairagency.TestObjectsInitializer;
import aoharkov.training.repairagency.domain.Order;
import aoharkov.training.repairagency.entity.OrderEntity;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OrderMapperTest {
    private static Mapper<OrderEntity, Order> orderMapper = MapperContext.getOrderMapper();
    private OrderEntity orderEntity;
    private Order order;

    @Before
    public void setUp() {
        orderEntity = TestObjectsInitializer.initOrderEntity();
        order = TestObjectsInitializer.initOrder();
    }

    @Test
    public void mapDomainToEntityShouldMapCorrectly() {
        assertEquals(orderEntity, orderMapper.mapDomainToEntity(order));
    }

    @Test
    public void mapEntityToDomainShouldMapCorrectly() {
        assertEquals(order, orderMapper.mapEntityToDomain(orderEntity));
    }
}