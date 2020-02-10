package aoharkov.training.repairagency.entity;

import aoharkov.training.repairagency.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Builder
@AllArgsConstructor
@Table(name = "users")
public class UserEntity {
    @Id
    @Column(name = "id", nullable = false)
    private final Integer id;

    @Column(name = "name", nullable = false)
    private final String name;

    @Column(name = "surname")
    private final String surname;

    @Column(name = "email", nullable = false)
    private final String email;

    @Column(name = "password", nullable = false)
    private final String password;

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private final Role role;
}
