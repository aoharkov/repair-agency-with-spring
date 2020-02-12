package aoharkov.training.repairagency.service.impl;

import aoharkov.training.repairagency.domain.Order;
import aoharkov.training.repairagency.domain.RepairStage;
import aoharkov.training.repairagency.domain.Request;
import aoharkov.training.repairagency.entity.OrderEntity;
import aoharkov.training.repairagency.entity.RepairStageEntity;
import aoharkov.training.repairagency.entity.RequestEntity;
import aoharkov.training.repairagency.repository.OrderRepository;
import aoharkov.training.repairagency.repository.RepairStageRepository;
import aoharkov.training.repairagency.repository.RequestRepository;
import aoharkov.training.repairagency.service.MasterService;
import aoharkov.training.repairagency.service.exception.EntityNotFoundException;
import aoharkov.training.repairagency.service.mapper.Mapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MasterServiceImpl implements MasterService {
    private final OrderRepository orderRepository;
    private final RequestRepository requestRepository;
    private final RepairStageRepository repairStageRepository;
    private final Mapper<RequestEntity, Request> requestMapper;
    private final Mapper<OrderEntity, Order> orderMapper;
    private final Mapper<RepairStageEntity, RepairStage> repairStageMapper;

    @Override
    public Page<Order> findAllOrders(int page, int itemsPerPage) {
        Page<OrderEntity> orderEntityPage = orderRepository.findAll(PageRequest.of(page, itemsPerPage));
        return orderEntityPage.map(orderMapper::mapEntityToDomain);
    }

    @Override
    public Request getRequest(Integer orderId) {
        Optional<OrderEntity> orderEntity = orderRepository.findById(orderId);
        if (orderEntity.isPresent()) {
            Optional<RequestEntity> requestEntity = requestRepository.findById(orderEntity.get().getRequest().getId());
            if (requestEntity.isPresent()) {
                return requestMapper.mapEntityToDomain(requestEntity.get());
            }
        }
        throw new EntityNotFoundException();
    }

    @Override
    public boolean updateRepairStage(Integer orderId, RepairStage repairStage) {
        Optional<OrderEntity> orderEntity = orderRepository.findById(orderId);
        if (orderEntity.isPresent()) {
            Order order = orderMapper.mapEntityToDomain(orderEntity.get());
            order.setRepairStage(repairStage);
            orderRepository.save(orderMapper.mapDomainToEntity(order));
            return true;
        }
        return false;
    }

    @Override
    public Page<RepairStage> findAllRepairStages(int page, int itemsPerPage) {
        Page<RepairStageEntity> repairStageEntityPage = repairStageRepository.findAll(PageRequest.of(page, itemsPerPage));
        return repairStageEntityPage.map(repairStageMapper::mapEntityToDomain);
    }
}
