package aoharkov.training.repairagency.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Request {
    private final Integer id;
    private final User client;
    private final String description;
    private Boolean viewed;
    private Boolean accepted;
}
