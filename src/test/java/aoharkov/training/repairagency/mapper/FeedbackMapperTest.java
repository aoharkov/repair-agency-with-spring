package aoharkov.training.repairagency.mapper;

import aoharkov.training.repairagency.domain.Feedback;
import aoharkov.training.repairagency.domain.Request;
import aoharkov.training.repairagency.entity.FeedbackEntity;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FeedbackMapperTest {
    private static final Mapper<FeedbackEntity, Feedback> MAPPER = new FeedbackMapper();
    private FeedbackEntity entity;
    private Feedback item;

    @Before
    public void setUp() {
        entity = FeedbackEntity.builder()
                .id(1)
                .requestId(2)
                .score(3)
                .text("UFO has published here")
                .build();
        item = Feedback.builder()
                .id(1)
                .request(Request.builder().id(2).build())
                .score(3)
                .text("UFO has published here")
                .build();
    }

    @Test
    public void mapDomainToEntityShouldMapCorrectly() {
        assertEquals(entity, MAPPER.mapDomainToEntity(item));
    }

    @Test
    public void mapEntityToDomainShouldMapCorrectly() {
        assertEquals(item, MAPPER.mapEntityToDomain(entity));
    }
}