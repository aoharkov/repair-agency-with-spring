package aoharkov.training.repairagency.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;

    @NotEmpty(message = "*Please, provide your name")
    @Length(max = 60, message = "*Your name must have no more than 60 characters")
    private String name;

    @Length(max = 60, message = "*Your surname must have no more than 60 characters")
    private String surname;

    @Email(message = "*Please, provide a valid Email")
    @Length(max = 60, message = "*Your email must have no more than 60 characters")
    private String email;

    @NotEmpty(message = "*Please, provide your password")
    @Length(min = 8, message = "*Your password must have at least 8 characters")
    @Length(max = 60, message = "*Your password must have no more than 60 characters")
    private String password;

    @NotNull
    private Role role;
}
