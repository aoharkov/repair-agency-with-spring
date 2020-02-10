package aoharkov.training.repairagency.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@AllArgsConstructor

@Entity
@Table(name = "requests")
public class RequestEntity {
    @Id
    @Column(name = "id")
    private final Integer id;

    @Column(name = "client_id")
    private final Integer clientId;

    @Column(name = "description")
    private final String description;

    @Column(name = "viewed")
    private final Boolean viewed;

    @Column(name = "accepted")
    private final Boolean accepted;
}
