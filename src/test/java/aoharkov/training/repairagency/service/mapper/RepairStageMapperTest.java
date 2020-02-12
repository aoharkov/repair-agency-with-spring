package aoharkov.training.repairagency.service.mapper;

import aoharkov.training.repairagency.TestObjectsInitializer;
import aoharkov.training.repairagency.domain.RepairStage;
import aoharkov.training.repairagency.entity.RepairStageEntity;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RepairStageMapperTest {
    private static Mapper<RepairStageEntity, RepairStage> repairStageMapper = MapperContext.getRepairStageMapper();
    private RepairStageEntity repairStageEntity;
    private RepairStage repairStage;

    @Before
    public void setUp() {
        repairStageEntity = TestObjectsInitializer.initRepairStageEntity();
        repairStage = TestObjectsInitializer.initRepairStage();
    }

    @Test
    public void mapDomainToEntityShouldMapCorrectly() {
        assertEquals(repairStageEntity, repairStageMapper.mapDomainToEntity(repairStage));
    }

    @Test
    public void mapEntityToDomainShouldMapCorrectly() {
        assertEquals(repairStage, repairStageMapper.mapEntityToDomain(repairStageEntity));
    }
}