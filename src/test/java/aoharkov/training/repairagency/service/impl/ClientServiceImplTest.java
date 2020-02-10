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
import aoharkov.training.repairagency.repository.domain.Page;
import aoharkov.training.repairagency.service.validator.UserValidatorImpl;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;
import java.util.Collections;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ClientServiceImplTest {
    private static final RequestEntity REQUEST_ENTITY = RequestEntity.builder()
            .id(1)
            .build();
    private static final Request REQUEST = Request.builder()
            .id(1)
            .build();
    private static final Page<RequestEntity> REQUEST_ENTITY_PAGE = Page.<RequestEntity>builder()
            .withItems(Arrays.asList(REQUEST_ENTITY, REQUEST_ENTITY))
            .build();
    private static final Page<Request> REQUEST_PAGE = Page.<Request>builder()
            .withItems(Collections.emptyList())
            .build();
    private static final OrderEntity ORDER_ENTITY = OrderEntity.builder()
            .id(2)
            .requestId(1)
            .build();
    private static final Order ORDER = Order.builder()
            .id(2)
            .request(REQUEST)
            .build();
    private static final RefusalEntity REFUSAL_ENTITY = RefusalEntity.builder()
            .id(3)
            .requestId(1)
            .build();
    private static final Refusal REFUSAL = Refusal.builder()
            .id(3)
            .request(REQUEST)
            .build();
    private static final FeedbackEntity FEEDBACK_ENTITY = FeedbackEntity.builder()
            .id(4)
            .requestId(1)
            .build();
    private static final Feedback FEEDBACK = Feedback.builder()
            .id(4)
            .request(REQUEST)
            .build();
    private static final RepairStageEntity REPAIR_STAGE_ENTITY = RepairStageEntity.builder()
            .id(5)
            .build();
    private static final RepairStage REPAIR_STAGE = RepairStage.builder()
            .id(5)
            .build();

    @Mock
    private UserValidatorImpl userValidator;
    @Mock
    private BCryptPasswordEncoder passwordEncoder;
    @Mock
    private UserRepository userRepository;
    @Mock
    private UserMapper userMapper;
    @Mock
    private RequestRepository requestRepository;
    @Mock
    private RefusalRepository refusalRepository;
    @Mock
    private OrderRepository orderRepository;
    @Mock
    private RepairStageRepository repairStageRepository;
    @Mock
    private FeedbackRepository feedbackRepository;
    @Mock
    private RequestMapper requestMapper;
    @Mock
    private RefusalMapper refusalMapper;
    @Mock
    private OrderMapper orderMapper;
    @Mock
    private RepairStageMapper repairStageMapper;
    @Mock
    private FeedbackMapper feedbackMapper;

    @InjectMocks
    private ClientServiceImpl clientService;

    @After
    public void resetMocks() {
        Mockito.reset(userValidator, passwordEncoder, userRepository, userMapper,
                requestRepository, refusalRepository, orderRepository, repairStageRepository, feedbackRepository,
                requestMapper, refusalMapper, orderMapper, repairStageMapper, feedbackMapper);
    }

    @Test
    public void saveRequestShouldSaveSuccessfully() {
        when(requestMapper.mapDomainToEntity(eq(REQUEST))).thenReturn(REQUEST_ENTITY);
        doNothing().when(requestRepository).save(REQUEST_ENTITY);

        clientService.saveRequest(REQUEST);

        verify(requestMapper).mapDomainToEntity(eq(REQUEST));
        verify(requestRepository).save(eq(REQUEST_ENTITY));
        verifyZeroInteractions(userValidator);
        verifyZeroInteractions(passwordEncoder);
        verifyZeroInteractions(userRepository);
        verifyZeroInteractions(userMapper);
        //verifyZeroInteractions(requestDao);
        verifyZeroInteractions(refusalRepository);
        verifyZeroInteractions(orderRepository);
        verifyZeroInteractions(repairStageRepository);
        verifyZeroInteractions(feedbackRepository);
        //verifyZeroInteractions(requestMapper);
        verifyZeroInteractions(refusalMapper);
        verifyZeroInteractions(orderMapper);
        verifyZeroInteractions(repairStageMapper);
        verifyZeroInteractions(feedbackMapper);
    }

    /*@Test
    public void findOwnRequestsShouldFindSuccessfully() {
        when(requestRepository.findAllByClientId(anyInt(), anyInt(), anyInt())).thenReturn(REQUEST_ENTITY_PAGE);
        when(requestMapper.mapEntityToDomain(eq(REQUEST_ENTITY))).thenReturn(REQUEST);

        clientService.findOwnRequests(1, 5, 1);

        verify(requestRepository).findAllByClientId(anyInt(), anyInt(), anyInt());
        verify(requestMapper, times(2)).mapEntityToDomain(eq(REQUEST_ENTITY));
        verifyZeroInteractions(userValidator);
        verifyZeroInteractions(passwordEncoder);
        verifyZeroInteractions(userRepository);
        verifyZeroInteractions(userMapper);
        //verifyZeroInteractions(requestDao);
        verifyZeroInteractions(refusalRepository);
        verifyZeroInteractions(orderRepository);
        verifyZeroInteractions(repairStageRepository);
        verifyZeroInteractions(feedbackRepository);
        //verifyZeroInteractions(requestMapper);
        verifyZeroInteractions(refusalMapper);
        verifyZeroInteractions(orderMapper);
        verifyZeroInteractions(repairStageMapper);
        verifyZeroInteractions(feedbackMapper);
    }*/

    @Test
    public void findOrder() {
    }

    @Test
    public void findRefusal() {
    }

    @Test
    public void saveFeedback() {
    }

    @Test
    public void findRepairStage() {
    }
}