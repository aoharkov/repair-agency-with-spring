package aoharkov.training.repairagency.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Request {
    private Integer id;

    @NotNull
    private User client;

    @NotEmpty(message = "*Please, provide description up to 255 characters")
    @Length(max = 60, message = "*Your request must have no more than 255 characters")
    private String description;

    private Boolean viewed;

    private Boolean accepted;
}
