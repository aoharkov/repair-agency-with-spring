package aoharkov.training.repairagency.service.mapper;

import aoharkov.training.repairagency.TestObjectsInitializer;
import aoharkov.training.repairagency.domain.Refusal;
import aoharkov.training.repairagency.entity.RefusalEntity;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RefusalMapperTest {
    private static Mapper<RefusalEntity, Refusal> refusalMapper = MapperContext.getRefusalMapper();
    private RefusalEntity refusalEntity;
    private Refusal refusal;

    @Before
    public void setUp() {
        refusalEntity = TestObjectsInitializer.initRefusalEntity();
        refusal = TestObjectsInitializer.initRefusal();
    }

    @Test
    public void mapDomainToEntityShouldMapCorrectly() {
        assertEquals(refusalEntity, refusalMapper.mapDomainToEntity(refusal));
    }

    @Test
    public void mapEntityToDomainShouldMapCorrectly() {
        assertEquals(refusal, refusalMapper.mapEntityToDomain(refusalEntity));
    }
}