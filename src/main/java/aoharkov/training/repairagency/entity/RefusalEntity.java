package aoharkov.training.repairagency.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Data
@Builder
@AllArgsConstructor
@Table(name = "refusals")
public class RefusalEntity {
    @Id
    @Column(name = "id", nullable = false)
    private final Integer id;

    @JoinColumn(name = "request_id", referencedColumnName = "id", nullable = false)
    private final Integer requestId;

    @Column(name = "explanation", nullable = false)
    private final String explanation;

    @JoinColumn(name = "manager_id", referencedColumnName = "id", nullable = false)
    private final Integer managerId;
}
