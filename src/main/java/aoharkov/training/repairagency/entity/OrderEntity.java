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
@Table(name = "orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @JoinColumn(name = "request_id", referencedColumnName = "id", nullable = false)
    private Integer requestId;

    @JoinColumn(name = "manager_id", referencedColumnName = "id", nullable = false)
    private Integer managerId;

    @Column(name = "price", nullable = false)
    private Integer price;

    @JoinColumn(name = "master_id", referencedColumnName = "id", nullable = false)
    private Integer masterId;

    @JoinColumn(name = "repair_stage_id", referencedColumnName = "id", nullable = false)
    private Integer repairStageId;
}
