package aoharkov.training.repairagency.service.impl;

import aoharkov.training.repairagency.domain.Feedback;
import aoharkov.training.repairagency.domain.Order;
import aoharkov.training.repairagency.domain.Refusal;
import aoharkov.training.repairagency.domain.Request;
import aoharkov.training.repairagency.entity.FeedbackEntity;
import aoharkov.training.repairagency.entity.OrderEntity;
import aoharkov.training.repairagency.entity.RefusalEntity;
import aoharkov.training.repairagency.entity.RequestEntity;
import aoharkov.training.repairagency.repository.FeedbackRepository;
import aoharkov.training.repairagency.repository.OrderRepository;
import aoharkov.training.repairagency.repository.RefusalRepository;
import aoharkov.training.repairagency.repository.RequestRepository;
import aoharkov.training.repairagency.service.ManagerService;
import aoharkov.training.repairagency.service.mapper.Mapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ManagerServiceImpl implements ManagerService {
    private final RequestRepository requestRepository;
    private final RefusalRepository refusalRepository;
    private final OrderRepository orderRepository;
    private final FeedbackRepository feedbackRepository;
    private final Mapper<RequestEntity, Request> requestMapper;
    private final Mapper<RefusalEntity, Refusal> refusalMapper;
    private final Mapper<OrderEntity, Order> orderMapper;
    private final Mapper<FeedbackEntity, Feedback> feedbackMapper;

    @Override
    public Page<Request> findAllRequests(int page, int itemsPerPage) {
        Page<RequestEntity> requestEntityPage = requestRepository.findAll(PageRequest.of(page, itemsPerPage));
        return requestEntityPage.map(requestMapper::mapEntityToDomain);
    }

    @Transactional
    @Override
    public boolean acceptRequest(Order order) {
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

    @Transactional
    @Override
    public boolean declineRequest(Refusal refusal) {
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

    @Override
    public Page<Feedback> findAllFeedback(int page, int itemsPerPage) {
        Page<FeedbackEntity> feedbackEntityPage = feedbackRepository.findAll(PageRequest.of(page, itemsPerPage));
        return feedbackEntityPage.map(feedbackMapper::mapEntityToDomain);
    }
}
