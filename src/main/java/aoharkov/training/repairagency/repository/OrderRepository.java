package aoharkov.training.repairagency.repository;

import aoharkov.training.repairagency.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {

    OrderEntity findByRequestId(Integer requestId);
}
