package aoharkov.training.repairagency.repository;

import aoharkov.training.repairagency.entity.RepairStageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepairStageRepository extends JpaRepository<RepairStageEntity, Integer> {

}
