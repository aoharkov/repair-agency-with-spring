package aoharkov.training.repairagency.repository;

import aoharkov.training.repairagency.entity.RequestEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends JpaRepository<RequestEntity, Integer> {

    Page<RequestEntity> findAllByClientId(Integer clientId, Pageable pageable);
}
