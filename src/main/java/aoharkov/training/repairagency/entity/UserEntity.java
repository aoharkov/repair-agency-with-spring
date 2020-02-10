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

@Data
@Builder
@AllArgsConstructor

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @Column(name = "id")
    private final Integer id;

    @Column(name = "name")
    private final String name;

    @Column(name = "surname")
    private final String surname;

    @Column(name = "email")
    private final String email;

    @Column(name = "password")
    private final String password;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private final Role role;
}
