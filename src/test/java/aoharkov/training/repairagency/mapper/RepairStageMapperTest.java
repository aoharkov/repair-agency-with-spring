package aoharkov.training.repairagency.mapper;

import aoharkov.training.repairagency.TestObjectsInitializer;
import aoharkov.training.repairagency.domain.RepairStage;
import aoharkov.training.repairagency.entity.RepairStageEntity;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RepairStageMapperTest {
    private static final Mapper<RepairStageEntity, RepairStage> MAPPER = new RepairStageMapper();
    private RepairStageEntity entity;
    private RepairStage item;

    @Before
    public void setUp() {
        entity = TestObjectsInitializer.initRepairStageEntity();
        item = TestObjectsInitializer.initRepairStage();
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