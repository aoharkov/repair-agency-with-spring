package aoharkov.training.repairagency.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;

    @NotEmpty(message = "*Please provide your name")
    private String name;

    private String surname;

    @Email(message = "*Please provide a valid Email")
    private String email;

    @NotEmpty(message = "*Please provide your password")
    @Length(min = 8, message = "*Your password must have at least 8 characters")
    private String password;

    private Role role;
}
