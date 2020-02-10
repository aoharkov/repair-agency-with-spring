package aoharkov.training.repairagency.repository;

import aoharkov.training.repairagency.entity.RequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<RequestEntity, Integer> {

    //Page<RequestEntity> findAllByClientId(int pageNumber, int itemsPerPage, int clientId);
}
