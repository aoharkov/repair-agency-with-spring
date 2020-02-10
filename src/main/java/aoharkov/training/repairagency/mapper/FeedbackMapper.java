package aoharkov.training.repairagency.mapper;

import aoharkov.training.repairagency.domain.Feedback;
import aoharkov.training.repairagency.domain.Request;
import aoharkov.training.repairagency.entity.FeedbackEntity;

public class FeedbackMapper implements Mapper<FeedbackEntity, Feedback> {

    @Override
    public FeedbackEntity mapDomainToEntity(Feedback item) {
        return FeedbackEntity.builder()
                .id(item.getId())
                .requestId(item.getRequest().getId())
                .score(item.getScore())
                .text(item.getText())
                .build();
    }

    @Override
    public Feedback mapEntityToDomain(FeedbackEntity entity) {
        return Feedback.builder()
                .id(entity.getId())
                .request(Request.builder().id(entity.getRequestId()).build())
                .score(entity.getScore())
                .text(entity.getText())
                .build();
    }
}
