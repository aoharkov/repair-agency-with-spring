package aoharkov.training.repairagency.service.mapper;

import aoharkov.training.repairagency.TestObjectsInitializer;
import aoharkov.training.repairagency.domain.Feedback;
import aoharkov.training.repairagency.entity.FeedbackEntity;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FeedbackMapperTest {
    private static Mapper<FeedbackEntity, Feedback> feedbackMapper = MapperContext.getFeedbackMapper();
    private FeedbackEntity feedbackEntity;
    private Feedback feedback;

    @Before
    public void setUp() {
        feedbackEntity = TestObjectsInitializer.initFeedbackEntity();
        feedback = TestObjectsInitializer.initFeedback();
    }

    @Test
    public void mapDomainToEntityShouldMapCorrectly() {
        assertEquals(feedbackEntity, feedbackMapper.mapDomainToEntity(feedback));
    }

    @Test
    public void mapEntityToDomainShouldMapCorrectly() {
        assertEquals(feedback, feedbackMapper.mapEntityToDomain(feedbackEntity));
    }
}