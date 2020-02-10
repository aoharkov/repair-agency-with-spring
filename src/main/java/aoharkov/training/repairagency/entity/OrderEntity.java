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
@Table(name = "orders")
public class OrderEntity {
    @Id
    @Column(name = "id", nullable = false)
    private final Integer id;

    @JoinColumn(name = "request_id", referencedColumnName = "id", nullable = false)
    private final Integer requestId;

    @JoinColumn(name = "manager_id", referencedColumnName = "id", nullable = false)
    private final Integer managerId;

    @Column(name = "price", nullable = false)
    private final Integer price;

    @JoinColumn(name = "master_id", referencedColumnName = "id", nullable = false)
    private final Integer masterId;

    @JoinColumn(name = "repair_stage_id", referencedColumnName = "id", nullable = false)
    private final Integer repairStageId;
}
