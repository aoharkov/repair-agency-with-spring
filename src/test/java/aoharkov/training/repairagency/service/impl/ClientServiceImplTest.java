package aoharkov.training.repairagency.service.impl;

import aoharkov.training.repairagency.TestObjectsInitializer;
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
import aoharkov.training.repairagency.service.mapper.FeedbackMapper;
import aoharkov.training.repairagency.service.mapper.OrderMapper;
import aoharkov.training.repairagency.service.mapper.RefusalMapper;
import aoharkov.training.repairagency.service.mapper.RepairStageMapper;
import aoharkov.training.repairagency.service.mapper.RequestMapper;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ClientServiceImplTest {
    private static final RequestEntity REQUEST_ENTITY = TestObjectsInitializer.initRequestEntity();
    private static final Request REQUEST = TestObjectsInitializer.initRequest();
    private static final OrderEntity ORDER_ENTITY = TestObjectsInitializer.initOrderEntity();
    private static final Order ORDER = TestObjectsInitializer.initOrder();
    private static final RefusalEntity REFUSAL_ENTITY = TestObjectsInitializer.initRefusalEntity();
    private static final Refusal REFUSAL = TestObjectsInitializer.initRefusal();
    private static final FeedbackEntity FEEDBACK_ENTITY = TestObjectsInitializer.initFeedbackEntity();
    private static final Feedback FEEDBACK = TestObjectsInitializer.initFeedback();
    private static final RepairStageEntity REPAIR_STAGE_ENTITY = TestObjectsInitializer.initRepairStageEntity();
    private static final RepairStage REPAIR_STAGE = TestObjectsInitializer.initRepairStage();

    @Rule
    public ExpectedException thrown = ExpectedException.none();

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
        Mockito.reset(requestRepository, refusalRepository, orderRepository, repairStageRepository, feedbackRepository,
                requestMapper, refusalMapper, orderMapper, repairStageMapper, feedbackMapper);
    }

    @Test
    public void saveRequestShouldSaveSuccessfully() {
        when(requestMapper.mapDomainToEntity(eq(REQUEST))).thenReturn(REQUEST_ENTITY);
        when(requestRepository.save(eq(REQUEST_ENTITY))).thenReturn(REQUEST_ENTITY);

        clientService.saveRequest(REQUEST);

        verify(requestMapper).mapDomainToEntity(eq(REQUEST));
        verify(requestRepository).save(eq(REQUEST_ENTITY));
    }
}