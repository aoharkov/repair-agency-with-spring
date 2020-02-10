package aoharkov.training.repairagency.service.impl;

import aoharkov.training.repairagency.domain.Order;
import aoharkov.training.repairagency.domain.Refusal;
import aoharkov.training.repairagency.domain.Request;
import aoharkov.training.repairagency.domain.User;
import aoharkov.training.repairagency.entity.RequestEntity;
import aoharkov.training.repairagency.mapper.FeedbackMapper;
import aoharkov.training.repairagency.mapper.OrderMapper;
import aoharkov.training.repairagency.mapper.RefusalMapper;
import aoharkov.training.repairagency.mapper.RequestMapper;
import aoharkov.training.repairagency.mapper.UserMapper;
import aoharkov.training.repairagency.repository.FeedbackRepository;
import aoharkov.training.repairagency.repository.OrderRepository;
import aoharkov.training.repairagency.repository.RefusalRepository;
import aoharkov.training.repairagency.repository.RequestRepository;
import aoharkov.training.repairagency.repository.UserRepository;
import aoharkov.training.repairagency.service.ManagerService;
import aoharkov.training.repairagency.service.encoder.Encoder;
import aoharkov.training.repairagency.service.validator.Validator;

import java.util.Optional;

public class ManagerServiceImpl extends UserServiceImpl implements ManagerService {
    private final RequestRepository requestRepository;
    private final RefusalRepository refusalRepository;
    private final OrderRepository orderRepository;
    private final FeedbackRepository feedbackRepository;
    private final RequestMapper requestMapper;
    private final RefusalMapper refusalMapper;
    private final OrderMapper orderMapper;
    private final FeedbackMapper feedbackMapper;

    public ManagerServiceImpl(Encoder encoder, Validator<User> userValidator,
                              UserRepository userRepository, RequestRepository requestRepository, RefusalRepository refusalRepository,
                              OrderRepository orderRepository, FeedbackRepository feedbackRepository,
                              UserMapper userMapper, RequestMapper requestMapper, RefusalMapper refusalMapper,
                              OrderMapper orderMapper, FeedbackMapper feedbackMapper) {
        super(encoder, userValidator, userRepository, userMapper);
        this.requestRepository = requestRepository;
        this.refusalRepository = refusalRepository;
        this.orderRepository = orderRepository;
        this.feedbackRepository = feedbackRepository;
        this.requestMapper = requestMapper;
        this.refusalMapper = refusalMapper;
        this.orderMapper = orderMapper;
        this.feedbackMapper = feedbackMapper;
    }

    /*@Override
    public List<Request> findAllRequests(int page, int itemsPerPage) {
        Page<RequestEntity> requestEntityPage = requestRepository.findAll(page, itemsPerPage);
        return requestEntityPage.getItems().stream()
                .map(requestMapper::mapEntityToDomain)
                .collect(Collectors.toList());
    }*/

    @Override
    public boolean acceptRequest(Order order) {
        //todo as transaction in dao
        Optional<RequestEntity> requestEntity = requestRepository.findById(order.getRequest().getId());
        if (requestEntity.isPresent()) {
            Request request = requestMapper.mapEntityToDomain(requestEntity.get());
            request.setViewed(true);
            request.setAccepted(true);
            requestRepository.save(requestMapper.mapDomainToEntity(request));
            orderRepository.save(orderMapper.mapDomainToEntity(order));
            return true;
        }
        return false;
    }

    @Override
    public boolean declineRequest(Refusal refusal) {
        //todo as transaction in dao
        Optional<RequestEntity> requestEntity = requestRepository.findById(refusal.getRequest().getId());
        if (requestEntity.isPresent()) {
            Request request = requestMapper.mapEntityToDomain(requestEntity.get());
            request.setViewed(true);
            request.setViewed(false);
            requestRepository.save(requestMapper.mapDomainToEntity(request));
            refusalRepository.save(refusalMapper.mapDomainToEntity(refusal));
            return true;
        }
        return false;
    }

   /* @Override
    public List<Feedback> findAllFeedback(int page, int itemsPerPage) {
        Page<FeedbackEntity> feedbackEntityPage = feedbackRepository.findAll(page, itemsPerPage);
        return feedbackEntityPage.getItems().stream()
                .map(feedbackMapper::mapEntityToDomain)
                .collect(Collectors.toList());
    }*/
}
