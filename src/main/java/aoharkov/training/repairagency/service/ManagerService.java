package aoharkov.training.repairagency.service;

import aoharkov.training.repairagency.domain.Order;
import aoharkov.training.repairagency.domain.Refusal;

public interface ManagerService {

    //List<Request> findAllRequests(int page, int itemsPerPage);

    boolean acceptRequest(Order order);

    boolean declineRequest(Refusal refusal);

    //List<Feedback> findAllFeedback(int page, int itemsPerPage);
}
