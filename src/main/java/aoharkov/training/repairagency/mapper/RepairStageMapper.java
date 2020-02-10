package aoharkov.training.repairagency.mapper;

import aoharkov.training.repairagency.domain.RepairStage;
import aoharkov.training.repairagency.entity.RepairStageEntity;
import org.springframework.stereotype.Component;

@Component
public class RepairStageMapper implements Mapper<RepairStageEntity, RepairStage> {

    @Override
    public RepairStageEntity mapDomainToEntity(RepairStage item) {
        return RepairStageEntity.builder()
                .id(item.getId())
                .name(item.getName())
                .build();
    }

    @Override
    public RepairStage mapEntityToDomain(RepairStageEntity entity) {
        return RepairStage.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }
}
