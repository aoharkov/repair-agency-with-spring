package aoharkov.training.repairagency.service.mapper;

import aoharkov.training.repairagency.domain.Feedback;
import aoharkov.training.repairagency.domain.Request;
import aoharkov.training.repairagency.entity.FeedbackEntity;
import org.springframework.stereotype.Component;

@Component
public class FeedbackMapper implements Mapper<FeedbackEntity, Feedback> {

    @Override
    public FeedbackEntity mapDomainToEntity(Feedback item) {
        return new FeedbackEntity(
                item.getId(),
                item.getRequest().getId(),
                item.getText(),
                item.getScore());
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
