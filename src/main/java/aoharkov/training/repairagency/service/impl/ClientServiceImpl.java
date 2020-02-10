package aoharkov.training.repairagency.service.impl;

import aoharkov.training.repairagency.domain.Feedback;
import aoharkov.training.repairagency.domain.Order;
import aoharkov.training.repairagency.domain.Refusal;
import aoharkov.training.repairagency.domain.RepairStage;
import aoharkov.training.repairagency.domain.Request;
import aoharkov.training.repairagency.domain.User;
import aoharkov.training.repairagency.entity.OrderEntity;
import aoharkov.training.repairagency.entity.RefusalEntity;
import aoharkov.training.repairagency.entity.RepairStageEntity;
import aoharkov.training.repairagency.mapper.FeedbackMapper;
import aoharkov.training.repairagency.mapper.OrderMapper;
import aoharkov.training.repairagency.mapper.RefusalMapper;
import aoharkov.training.repairagency.mapper.RepairStageMapper;
import aoharkov.training.repairagency.mapper.RequestMapper;
import aoharkov.training.repairagency.mapper.UserMapper;
import aoharkov.training.repairagency.repository.FeedbackRepository;
import aoharkov.training.repairagency.repository.OrderRepository;
import aoharkov.training.repairagency.repository.RefusalRepository;
import aoharkov.training.repairagency.repository.RepairStageRepository;
import aoharkov.training.repairagency.repository.RequestRepository;
import aoharkov.training.repairagency.repository.UserRepository;
import aoharkov.training.repairagency.service.ClientService;
import aoharkov.training.repairagency.service.encoder.Encoder;
import aoharkov.training.repairagency.service.exception.EntityNotFoundException;
import aoharkov.training.repairagency.service.validator.Validator;

import java.util.Optional;

public class ClientServiceImpl extends UserServiceImpl implements ClientService {
    private final RequestRepository requestRepository;
    private final RefusalRepository refusalRepository;
    private final OrderRepository orderRepository;
    private final RepairStageRepository repairStageRepository;
    private final FeedbackRepository feedbackRepository;
    private final RequestMapper requestMapper;
    private final RefusalMapper refusalMapper;
    private final OrderMapper orderMapper;
    private final RepairStageMapper repairStageMapper;
    private final FeedbackMapper feedbackMapper;

    public ClientServiceImpl(Encoder encoder, Validator<User> userValidator,
                             UserRepository userRepository, RequestRepository requestRepository, RefusalRepository refusalRepository,
                             OrderRepository orderRepository, RepairStageRepository repairStageRepository, FeedbackRepository feedbackRepository,
                             UserMapper userMapper, RequestMapper requestMapper, RefusalMapper refusalMapper,
                             OrderMapper orderMapper, RepairStageMapper repairStageMapper, FeedbackMapper feedbackMapper) {
        super(encoder, userValidator, userRepository, userMapper);
        this.requestRepository = requestRepository;
        this.refusalRepository = refusalRepository;
        this.orderRepository = orderRepository;
        this.repairStageRepository = repairStageRepository;
        this.feedbackRepository = feedbackRepository;
        this.requestMapper = requestMapper;
        this.refusalMapper = refusalMapper;
        this.orderMapper = orderMapper;
        this.repairStageMapper = repairStageMapper;
        this.feedbackMapper = feedbackMapper;
    }

    @Override
    public void saveRequest(Request request) {
        requestRepository.save(requestMapper.mapDomainToEntity(request));
    }

    /*@Override
    public List<Request> findOwnRequests(int page, int itemsPerPage, Integer clientId) {
        Page<RequestEntity> requestEntityPage = requestRepository.findAllByClientId(page, itemsPerPage, clientId);
        return requestEntityPage.getItems().stream()
                .map(requestMapper::mapEntityToDomain)
                .collect(Collectors.toList());
    }*/

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
