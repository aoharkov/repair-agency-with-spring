package aoharkov.training.repairagency;

import aoharkov.training.repairagency.domain.Feedback;
import aoharkov.training.repairagency.domain.Order;
import aoharkov.training.repairagency.domain.Refusal;
import aoharkov.training.repairagency.domain.RepairStage;
import aoharkov.training.repairagency.domain.Request;
import aoharkov.training.repairagency.domain.Role;
import aoharkov.training.repairagency.domain.User;
import aoharkov.training.repairagency.entity.FeedbackEntity;
import aoharkov.training.repairagency.entity.OrderEntity;
import aoharkov.training.repairagency.entity.RefusalEntity;
import aoharkov.training.repairagency.entity.RepairStageEntity;
import aoharkov.training.repairagency.entity.RequestEntity;
import aoharkov.training.repairagency.entity.UserEntity;

public abstract class TestObjectsInitializer {
    private static final int CLIENT_ID = 1;
    private static final int MANAGER_ID = 2;
    private static final int MASTER_ID = 3;
    private static final int REQUEST_ID = 4;
    private static final int ORDER_ID = 5;
    private static final int REFUSAL_ID = 6;
    private static final int FEEDBACK_ID = 7;
    private static final int REPAIR_STAGE_ID = 8;

    public static UserEntity initUserEntity(int id) {
        return new UserEntity(id, "John", "Doe", "admin@gmail.com", "password", Role.CLIENT);
    }

    public static User initUser(int id) {
        return User.builder()
                .id(id)
                .name("John")
                .surname("Doe")
                .email("admin@gmail.com")
                .password("password")
                .role(Role.CLIENT)
                .build();
    }

    public static RequestEntity initRequestEntity() {
        RequestEntity requestEntity = new RequestEntity();
        requestEntity.setId(REQUEST_ID);
        requestEntity.setClient(initUserEntity(CLIENT_ID));
        requestEntity.setDescription("just do it");
        requestEntity.setViewed(false);
        requestEntity.setAccepted(false);
        return requestEntity;
    }

    public static Request initRequest() {
        return Request.builder()
                .id(REQUEST_ID)
                .description("just do it")
                .client(initUser(CLIENT_ID))
                .viewed(false)
                .accepted(false)
                .build();
    }

    public static OrderEntity initOrderEntity() {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(ORDER_ID);
        orderEntity.setManager(initUserEntity(MANAGER_ID));
        orderEntity.setPrice(4000);
        orderEntity.setMaster(initUserEntity(MASTER_ID));
        orderEntity.setRepairStage(initRepairStageEntity());
        orderEntity.setRequest(initRequestEntity());
        return orderEntity;
    }

    public static Order initOrder() {
        return Order.builder()
                .id(ORDER_ID)
                .manager(initUser(MANAGER_ID))
                .master(initUser(MASTER_ID))
                .price(4000)
                .repairStage(initRepairStage())
                .request(initRequest())
                .build();
    }

    public static RefusalEntity initRefusalEntity() {
        return new RefusalEntity(REFUSAL_ID, initRequestEntity(), "because", initUserEntity(MANAGER_ID));
    }

    public static Refusal initRefusal() {
        return Refusal.builder()
                .id(REFUSAL_ID)
                .explanation("because")
                .manager(initUser(MANAGER_ID))
                .request(initRequest())
                .build();
    }

    public static FeedbackEntity initFeedbackEntity() {
        return new FeedbackEntity(FEEDBACK_ID, initRequestEntity(), "UFO has published here", 3);
    }

    public static Feedback initFeedback() {
        return Feedback.builder()
                .id(FEEDBACK_ID)
                .request(initRequest())
                .score(3)
                .text("UFO has published here")
                .build();
    }

    public static RepairStageEntity initRepairStageEntity() {
        return new RepairStageEntity(REPAIR_STAGE_ID, "first stage");
    }

    public static RepairStage initRepairStage() {
        return RepairStage.builder()
                .id(REPAIR_STAGE_ID)
                .name("first stage")
                .build();
    }
}
