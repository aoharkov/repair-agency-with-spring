package aoharkov.training.repairagency.service.mapper;

import aoharkov.training.repairagency.domain.Feedback;
import aoharkov.training.repairagency.domain.Request;
import aoharkov.training.repairagency.entity.FeedbackEntity;
import aoharkov.training.repairagency.entity.RequestEntity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("feedbackMapper")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class FeedbackMapper implements Mapper<FeedbackEntity, Feedback> {
    @Qualifier("requestMapper")
    private Mapper<RequestEntity, Request> requestMapper;

    @Override
    public FeedbackEntity mapDomainToEntity(Feedback feedback) {
        if (feedback == null) {
            return null;
        }
        FeedbackEntity feedbackEntity = new FeedbackEntity();
        feedbackEntity.setId(feedback.getId());
        feedbackEntity.setRequest(requestMapper.mapDomainToEntity(feedback.getRequest()));
        feedbackEntity.setText(feedback.getText());
        feedbackEntity.setScore(feedback.getScore());
        return feedbackEntity;
    }

    @Override
    public Feedback mapEntityToDomain(FeedbackEntity feedbackEntity) {
        if (feedbackEntity == null) {
            return null;
        }
        return Feedback.builder()
                .id(feedbackEntity.getId())
                .request(requestMapper.mapEntityToDomain(feedbackEntity.getRequest()))
                .score(feedbackEntity.getScore())
                .text(feedbackEntity.getText())
                .build();
    }
}
