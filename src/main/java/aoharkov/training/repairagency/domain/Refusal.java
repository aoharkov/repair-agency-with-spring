package aoharkov.training.repairagency.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Refusal {
    private final Integer id;
    private final Request request;
    private final String explanation;
    private final User manager;
}
