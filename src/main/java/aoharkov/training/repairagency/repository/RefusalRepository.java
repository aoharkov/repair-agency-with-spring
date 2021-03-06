package aoharkov.training.repairagency.repository;

import aoharkov.training.repairagency.entity.RefusalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefusalRepository extends JpaRepository<RefusalEntity, Integer> {

    RefusalEntity findByRequestId(Integer requestId);
}
