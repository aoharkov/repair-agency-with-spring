package aoharkov.training.repairagency.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class RepairStage {
    private final Integer id;
    private final String name;
}
