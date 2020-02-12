package aoharkov.training.repairagency.service.mapper;

import aoharkov.training.repairagency.domain.Feedback;
import aoharkov.training.repairagency.domain.Order;
import aoharkov.training.repairagency.domain.Refusal;
import aoharkov.training.repairagency.domain.RepairStage;
import aoharkov.training.repairagency.domain.Request;
import aoharkov.training.repairagency.domain.User;
import aoharkov.training.repairagency.entity.FeedbackEntity;
import aoharkov.training.repairagency.entity.OrderEntity;
import aoharkov.training.repairagency.entity.RefusalEntity;
import aoharkov.training.repairagency.entity.RepairStageEntity;
import aoharkov.training.repairagency.entity.RequestEntity;
import aoharkov.training.repairagency.entity.UserEntity;
import aoharkov.training.repairagency.service.mapper.FeedbackMapper;
import aoharkov.training.repairagency.service.mapper.Mapper;
import aoharkov.training.repairagency.service.mapper.OrderMapper;
import aoharkov.training.repairagency.service.mapper.RefusalMapper;
import aoharkov.training.repairagency.service.mapper.RepairStageMapper;
import aoharkov.training.repairagency.service.mapper.RequestMapper;
import aoharkov.training.repairagency.service.mapper.UserMapper;

abstract class MapperContext {
    private static final Mapper<UserEntity, User> USER_MAPPER = new UserMapper();

    private static final Mapper<RequestEntity, Request> REQUEST_MAPPER = new RequestMapper(USER_MAPPER);

    private static final Mapper<RefusalEntity, Refusal> REFUSAL_MAPPER = new RefusalMapper(REQUEST_MAPPER, USER_MAPPER);

    private static final Mapper<RepairStageEntity, RepairStage> REPAIR_STAGE_MAPPER = new RepairStageMapper();

    private static final Mapper<OrderEntity, Order> ORDER_MAPPER =
            new OrderMapper(REQUEST_MAPPER, USER_MAPPER, REPAIR_STAGE_MAPPER);

    private static final Mapper<FeedbackEntity, Feedback> FEEDBACK_MAPPER = new FeedbackMapper(REQUEST_MAPPER);

    public static Mapper<UserEntity, User> getUserMapper() {
        return USER_MAPPER;
    }

    public static Mapper<RequestEntity, Request> getRequestMapper() {
        return REQUEST_MAPPER;
    }

    public static Mapper<RefusalEntity, Refusal> getRefusalMapper() {
        return REFUSAL_MAPPER;
    }

    public static Mapper<RepairStageEntity, RepairStage> getRepairStageMapper() {
        return REPAIR_STAGE_MAPPER;
    }

    public static Mapper<OrderEntity, Order> getOrderMapper() {
        return ORDER_MAPPER;
    }

    public static Mapper<FeedbackEntity, Feedback> getFeedbackMapper() {
        return FEEDBACK_MAPPER;
    }
}
