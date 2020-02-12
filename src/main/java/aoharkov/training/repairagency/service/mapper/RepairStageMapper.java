package aoharkov.training.repairagency.service.mapper;

import aoharkov.training.repairagency.domain.RepairStage;
import aoharkov.training.repairagency.entity.RepairStageEntity;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("repairStageMapper")
public class RepairStageMapper implements Mapper<RepairStageEntity, RepairStage> {

    @Override
    public RepairStageEntity mapDomainToEntity(RepairStage repairStage) {
        if (repairStage == null) {
            return null;
        }
        RepairStageEntity repairStageEntity = new RepairStageEntity();
        repairStageEntity.setId(repairStage.getId());
        repairStageEntity.setName(repairStage.getName());
        return repairStageEntity;
    }

    @Override
    public RepairStage mapEntityToDomain(RepairStageEntity repairStageEntity) {
        if (repairStageEntity == null) {
            return null;
        }
        return RepairStage.builder()
                .id(repairStageEntity.getId())
                .name(repairStageEntity.getName())
                .build();
    }
}
