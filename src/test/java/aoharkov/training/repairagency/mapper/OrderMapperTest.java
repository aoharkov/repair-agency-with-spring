package aoharkov.training.repairagency.mapper;

import aoharkov.training.repairagency.domain.Order;
import aoharkov.training.repairagency.domain.RepairStage;
import aoharkov.training.repairagency.domain.Request;
import aoharkov.training.repairagency.domain.User;
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
        entity = OrderEntity.builder()
                .id(1)
                .managerId(2)
                .masterId(3)
                .price(4000)
                .repairStageId(5)
                .requestId(6)
                .build();

        item = Order.builder()
                .id(1)
                .manager(User.builder().id(2).build())
                .master(User.builder().id(3).build())
                .price(4000)
                .repairStage(RepairStage.builder().id(5).build())
                .request(Request.builder().id(6).build())
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