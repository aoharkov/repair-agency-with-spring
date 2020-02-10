package aoharkov.training.repairagency.service;

import aoharkov.training.repairagency.domain.Order;
import aoharkov.training.repairagency.domain.Refusal;
import org.springframework.stereotype.Service;

@Service
public interface ManagerService extends UserService {

    //List<Request> findAllRequests(int page, int itemsPerPage);

    boolean acceptRequest(Order order);

    boolean declineRequest(Refusal refusal);

    //List<Feedback> findAllFeedback(int page, int itemsPerPage);
}
