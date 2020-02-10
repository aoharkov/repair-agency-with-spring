package aoharkov.training.repairagency.repository;

import aoharkov.training.repairagency.entity.FeedbackEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<FeedbackEntity, Integer> {

}
