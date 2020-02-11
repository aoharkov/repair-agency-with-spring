package aoharkov.training.repairagency.service.mapper;

import aoharkov.training.repairagency.domain.Order;
import aoharkov.training.repairagency.domain.RepairStage;
import aoharkov.training.repairagency.domain.Request;
import aoharkov.training.repairagency.domain.User;
import aoharkov.training.repairagency.entity.OrderEntity;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper implements Mapper<OrderEntity, Order> {

    @Override
    public OrderEntity mapDomainToEntity(Order item) {
        return new OrderEntity(
                item.getId(),
                item.getRequest().getId(),
                item.getManager().getId(),
                item.getPrice(),
                item.getMaster().getId(),
                item.getRepairStage().getId());
    }

    @Override
    public Order mapEntityToDomain(OrderEntity entity) {
        return Order.builder()
                .id(entity.getId())
                .manager(User.builder().id(entity.getManagerId()).build())
                .master(User.builder().id(entity.getMasterId()).build())
                .price(entity.getPrice())
                .repairStage(RepairStage.builder().id(entity.getRepairStageId()).build())
                .request(Request.builder().id(entity.getRequestId()).build())
                .build();
    }
}
