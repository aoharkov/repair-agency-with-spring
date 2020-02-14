package aoharkov.training.repairagency.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Feedback {
    private Integer id;

    @NotNull
    private Request request;

    @Length(max = 255, message = "*Your feedback must have no more than 255 characters")
    private String text;

    private Integer score;
}
