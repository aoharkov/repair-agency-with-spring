package aoharkov.training.repairagency.service;

import aoharkov.training.repairagency.domain.Feedback;
import aoharkov.training.repairagency.domain.Order;
import aoharkov.training.repairagency.domain.Refusal;
import aoharkov.training.repairagency.domain.RepairStage;
import aoharkov.training.repairagency.domain.Request;
import org.springframework.data.domain.Page;

public interface ClientService {

    void saveRequest(Request request);

    Page<Request> findOwnRequests(Integer id, int page, int itemsPerPage);

    Order findOrder(Integer requestId);

    Refusal findRefusal(Integer requestId);

    void saveFeedback(Feedback feedback);

    RepairStage findRepairStage(Integer requestId);
}
