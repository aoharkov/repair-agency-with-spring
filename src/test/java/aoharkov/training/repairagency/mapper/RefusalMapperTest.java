package aoharkov.training.repairagency.mapper;

import aoharkov.training.repairagency.domain.Refusal;
import aoharkov.training.repairagency.domain.Request;
import aoharkov.training.repairagency.domain.User;
import aoharkov.training.repairagency.entity.RefusalEntity;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RefusalMapperTest {
    private static final Mapper<RefusalEntity, Refusal> MAPPER = new RefusalMapper();
    private RefusalEntity entity;
    private Refusal item;

    @Before
    public void setUp() {
        entity = RefusalEntity.builder()
                .id(1)
                .explanation("because")
                .managerId(2)
                .requestId(3)
                .build();
        item = Refusal.builder()
                .id(1)
                .explanation("because")
                .manager(User.builder().id(2).build())
                .request(Request.builder().id(3).build())
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