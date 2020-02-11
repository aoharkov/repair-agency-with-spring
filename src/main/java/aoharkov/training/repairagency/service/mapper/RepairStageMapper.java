package aoharkov.training.repairagency.service.mapper;

import aoharkov.training.repairagency.domain.RepairStage;
import aoharkov.training.repairagency.entity.RepairStageEntity;
import org.springframework.stereotype.Component;

@Component
public class RepairStageMapper implements Mapper<RepairStageEntity, RepairStage> {

    @Override
    public RepairStageEntity mapDomainToEntity(RepairStage repairStage) {
        return new RepairStageEntity(
                repairStage.getId(),
                repairStage.getName());
    }

    @Override
    public RepairStage mapEntityToDomain(RepairStageEntity entity) {
        return RepairStage.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }
}
