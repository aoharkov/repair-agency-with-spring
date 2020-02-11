package aoharkov.training.repairagency.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@Table(name = "requests")
public class RequestEntity {
    @Id
    @Column(name = "id", nullable = false)
    private final Integer id;

    @JoinColumn(name = "client_id", referencedColumnName = "id", nullable = false)
    private final Integer clientId;

    @Column(name = "description", nullable = false)
    private final String description;

    @Column(name = "viewed")
    private final Boolean viewed;

    @Column(name = "accepted")
    private final Boolean accepted;
}
