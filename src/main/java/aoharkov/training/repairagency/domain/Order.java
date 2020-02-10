package aoharkov.training.repairagency.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Order {
    private final Integer id;
    private final Request request;
    private final User manager;
    private final Integer price;
    private final User master;
    private RepairStage repairStage;
}
