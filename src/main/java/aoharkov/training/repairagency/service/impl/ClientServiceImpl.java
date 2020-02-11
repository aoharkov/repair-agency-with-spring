package aoharkov.training.repairagency.service.impl;

import aoharkov.training.repairagency.domain.Feedback;
import aoharkov.training.repairagency.domain.Order;
import aoharkov.training.repairagency.domain.Refusal;
import aoharkov.training.repairagency.domain.RepairStage;
import aoharkov.training.repairagency.domain.Request;
import aoharkov.training.repairagency.entity.FeedbackEntity;
import aoharkov.training.repairagency.entity.OrderEntity;
import aoharkov.training.repairagency.entity.RefusalEntity;
import aoharkov.training.repairagency.entity.RepairStageEntity;
import aoharkov.training.repairagency.entity.RequestEntity;
import aoharkov.training.repairagency.repository.FeedbackRepository;
import aoharkov.training.repairagency.repository.OrderRepository;
import aoharkov.training.repairagency.repository.RefusalRepository;
import aoharkov.training.repairagency.repository.RepairStageRepository;
import aoharkov.training.repairagency.repository.RequestRepository;
import aoharkov.training.repairagency.service.ClientService;
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
public class ClientServiceImpl implements ClientService {
    private final RequestRepository requestRepository;
    private final RefusalRepository refusalRepository;
    private final OrderRepository orderRepository;
    private final RepairStageRepository repairStageRepository;
    private final FeedbackRepository feedbackRepository;
    private final Mapper<RequestEntity, Request> requestMapper;
    private final Mapper<RefusalEntity, Refusal> refusalMapper;
    private final Mapper<OrderEntity, Order> orderMapper;
    private final Mapper<RepairStageEntity, RepairStage> repairStageMapper;
    private final Mapper<FeedbackEntity, Feedback> feedbackMapper;


    @Override
    public void saveRequest(Request request) {
        requestRepository.save(requestMapper.mapDomainToEntity(request));
    }

    @Override
    public Page<Request> findOwnRequests(Integer clientId, int page, int itemsPerPage) {
        Page<RequestEntity> requestEntityPage =
                requestRepository.findAllByClientId(clientId, PageRequest.of(page, itemsPerPage));

        return requestEntityPage.map(requestMapper::mapEntityToDomain);
    }

    @Override
    public Order findOrder(Integer requestId) {
        OrderEntity orderEntity = orderRepository.findByRequestId(requestId);
        if (orderEntity != null) {
            return orderMapper.mapEntityToDomain(orderEntity);
        }
        throw new EntityNotFoundException();
    }

    @Override
    public Refusal findRefusal(Integer requestId) {
        RefusalEntity refusalEntity = refusalRepository.findByRequestId(requestId);
        if (refusalEntity != null) {
            return refusalMapper.mapEntityToDomain(refusalEntity);
        }
        throw new EntityNotFoundException();
    }

    @Override
    public void saveFeedback(Feedback feedback) {
        feedbackRepository.save(feedbackMapper.mapDomainToEntity(feedback));
    }

    @Override
    public RepairStage findRepairStage(Integer requestId) {
        Integer repairStageId = findOrder(requestId).getRepairStage().getId();
        Optional<RepairStageEntity> repairStageEntity = repairStageRepository.findById(repairStageId);
        if (repairStageEntity.isPresent()) {
            return repairStageMapper.mapEntityToDomain(repairStageEntity.get());
        }
        throw new EntityNotFoundException();
    }
}
