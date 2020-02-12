package aoharkov.training.repairagency.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "refusals")
public class RefusalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @JoinColumn(name = "request_id", referencedColumnName = "id", nullable = false)
    private Integer requestId;

    @Column(name = "explanation", nullable = false)
    private String explanation;

    @JoinColumn(name = "manager_id", referencedColumnName = "id", nullable = false)
    private Integer managerId;
}
