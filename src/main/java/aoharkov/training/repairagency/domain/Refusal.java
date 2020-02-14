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
public class Refusal {
    private Integer id;

    @NotNull
    private Request request;

    @NotEmpty(message = "*Please, provide explanation up to 255 characters")
    @Length(max = 255, message = "*Your explanation must have no more than 255 characters")
    private String explanation;

    @NotNull
    private User manager;
}
