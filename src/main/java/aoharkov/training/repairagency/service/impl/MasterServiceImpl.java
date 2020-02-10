package aoharkov.training.repairagency.service.impl;

import aoharkov.training.repairagency.domain.Order;
import aoharkov.training.repairagency.domain.RepairStage;
import aoharkov.training.repairagency.domain.Request;
import aoharkov.training.repairagency.entity.OrderEntity;
import aoharkov.training.repairagency.entity.RequestEntity;
import aoharkov.training.repairagency.mapper.OrderMapper;
import aoharkov.training.repairagency.mapper.RepairStageMapper;
import aoharkov.training.repairagency.mapper.RequestMapper;
import aoharkov.training.repairagency.repository.OrderRepository;
import aoharkov.training.repairagency.repository.RepairStageRepository;
import aoharkov.training.repairagency.repository.RequestRepository;
import aoharkov.training.repairagency.service.MasterService;
import aoharkov.training.repairagency.service.exception.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MasterServiceImpl implements MasterService {
    private final OrderRepository orderRepository;
    private final RequestRepository requestRepository;
    private final RepairStageRepository repairStageRepository;
    private final RequestMapper requestMapper;
    private final OrderMapper orderMapper;
    private final RepairStageMapper repairStageMapper;

/*    @Override
    public List<Order> findAllOrders(int page, int itemsPerPage) {
        Page<OrderEntity> orderEntityPage = orderRepository.findAll(page, itemsPerPage);
        return orderEntityPage.getItems().stream()
                .map(orderMapper::mapEntityToDomain)
                .collect(Collectors.toList());
    }*/

    @Override
    public Request getRequest(Integer orderId) {
        Optional<OrderEntity> orderEntity = orderRepository.findById(orderId);
        if (orderEntity.isPresent()) {
            Optional<RequestEntity> requestEntity = requestRepository.findById(orderEntity.get().getRequestId());
            if (requestEntity.isPresent()) {
                return requestMapper.mapEntityToDomain(requestEntity.get());
            }
        }
        throw new EntityNotFoundException();
    }

    @Override
    public boolean updateRepairStage(Order order, RepairStage repairStage) {
        Optional<OrderEntity> orderEntity = orderRepository.findById(order.getId());
        if (orderEntity.isPresent()) {
            order.setRepairStage(repairStage);
            orderRepository.save(orderMapper.mapDomainToEntity(order));
            return true;
        }
        return false;
    }

    /*@Override
    public List<RepairStage> findAllRepairStages(int page, int itemsPerPage) {
        Page<RepairStageEntity> repairStageEntityPage = repairStageRepository.findAll(page, itemsPerPage);
        return repairStageEntityPage.getItems().stream()
                .map(repairStageMapper::mapEntityToDomain)
                .collect(Collectors.toList());
    }*/
}
