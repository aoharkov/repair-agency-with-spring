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
import org.springframework.data.domain.Page;

import java.util.Arrays;
import java.util.Collections;

public class TestObjectsInitializer {
    public static UserEntity initUserEntity() {
        return new UserEntity(1, "John", "Doe", "admin@gmail.com", "password", Role.CLIENT);
    }

    public static User initUser() {
        return User.builder()
                .id(1)
                .name("John")
                .surname("Doe")
                .email("admin@gmail.com")
                .password("password")
                .role(Role.CLIENT)
                .build();
    }

    public static RequestEntity initRequestEntity() {
        return new RequestEntity(1, 2, "just do it", false, false);
    }

    public static Request initRequest() {
        return Request.builder()
                .id(1)
                .description("just do it")
                .client(User.builder().id(2).build())
                .viewed(false)
                .accepted(false)
                .build();
    }

    public static OrderEntity initOrderEntity() {
        return new OrderEntity(1, 6, 2, 4000, 3, 5);
    }

    public static Order initOrder() {
        return Order.builder()
                .id(1)
                .manager(User.builder().id(2).build())
                .master(User.builder().id(3).build())
                .price(4000)
                .repairStage(RepairStage.builder().id(5).build())
                .request(Request.builder().id(6).build())
                .build();
    }

    public static RefusalEntity initRefusalEntity() {
        return new RefusalEntity(1, 3, "because", 2);
    }

    public static Refusal initRefusal() {
        return Refusal.builder()
                .id(1)
                .explanation("because")
                .manager(User.builder().id(2).build())
                .request(Request.builder().id(3).build())
                .build();
    }

    public static FeedbackEntity initFeedbackEntity() {
        return new FeedbackEntity(1, 2, "UFO has published here", 3);
    }

    public static Feedback initFeedback() {
        return Feedback.builder()
                .id(1)
                .request(Request.builder().id(2).build())
                .score(3)
                .text("UFO has published here")
                .build();
    }

    public static RepairStageEntity initRepairStageEntity() {
        return new RepairStageEntity(1, "first stage");
    }

    public static RepairStage initRepairStage() {
        return RepairStage.builder()
                .id(1)
                .name("first stage")
                .build();
    }
}
