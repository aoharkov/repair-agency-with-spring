package aoharkov.training.repairagency.service;

import aoharkov.training.repairagency.domain.Order;
import aoharkov.training.repairagency.domain.RepairStage;
import aoharkov.training.repairagency.domain.Request;
import org.springframework.data.domain.Page;

public interface MasterService {

    Page<Order> findAllOrders(int page, int itemsPerPage);

    Request getRequest(Integer orderId);

    boolean updateRepairStage(Integer orderId, RepairStage newRepairStage);

    Page<RepairStage> findAllRepairStages(int page, int itemsPerPage);
}
