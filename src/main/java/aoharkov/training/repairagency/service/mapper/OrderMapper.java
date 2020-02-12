package aoharkov.training.repairagency.service.mapper;

import aoharkov.training.repairagency.domain.Order;
import aoharkov.training.repairagency.domain.RepairStage;
import aoharkov.training.repairagency.domain.Request;
import aoharkov.training.repairagency.domain.User;
import aoharkov.training.repairagency.entity.OrderEntity;
import aoharkov.training.repairagency.entity.RepairStageEntity;
import aoharkov.training.repairagency.entity.RequestEntity;
import aoharkov.training.repairagency.entity.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("orderMapper")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class OrderMapper implements Mapper<OrderEntity, Order> {
    @Qualifier("requestMapper")
    private Mapper<RequestEntity, Request> requestMapper;
    @Qualifier("userMapper")
    private Mapper<UserEntity, User> userMapper;
    @Qualifier("repairStageMapper")
    private Mapper<RepairStageEntity, RepairStage> repairStageMapper;

    @Override
    public OrderEntity mapDomainToEntity(Order order) {
        if (order == null) {
            return null;
        }
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(order.getId());
        orderEntity.setRequest(requestMapper.mapDomainToEntity(order.getRequest()));
        orderEntity.setManager(userMapper.mapDomainToEntity(order.getManager()));
        orderEntity.setPrice(order.getPrice());
        orderEntity.setMaster(userMapper.mapDomainToEntity(order.getMaster()));
        orderEntity.setRepairStage(repairStageMapper.mapDomainToEntity(order.getRepairStage()));
        return orderEntity;
    }

    @Override
    public Order mapEntityToDomain(OrderEntity orderEntity) {
        if (orderEntity == null) {
            return null;
        }
        return Order.builder()
                .id(orderEntity.getId())
                .manager(userMapper.mapEntityToDomain(orderEntity.getManager()))
                .master(userMapper.mapEntityToDomain(orderEntity.getMaster()))
                .price(orderEntity.getPrice())
                .repairStage(repairStageMapper.mapEntityToDomain(orderEntity.getRepairStage()))
                .request(requestMapper.mapEntityToDomain(orderEntity.getRequest()))
                .build();
    }
}
