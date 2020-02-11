package aoharkov.training.repairagency.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "requests")
public class RequestEntity {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @JoinColumn(name = "client_id", referencedColumnName = "id", nullable = false)
    private Integer clientId;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "viewed")
    private Boolean viewed;

    @Column(name = "accepted")
    private Boolean accepted;
}
