package aoharkov.training.repairagency.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RepairStage {
    private Integer id;

    @NotEmpty(message = "*Please, provide short name for stage up to 80 characters")
    @Length(max = 80, message = "*Provided name must have no more than 80 characters")
    private String name;
}
