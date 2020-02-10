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
@Table(name = "orders")
public class OrderEntity {
    @Id
    @Column(name = "id")
    private final Integer id;

    @Column(name = "request_id")
    private final Integer requestId;

    @Column(name = "manager_id")
    private final Integer managerId;

    @Column(name = "price")
    private final Integer price;

    @Column(name = "master_id")
    private final Integer masterId;

    @Column(name = "repair_stage_id")
    private final Integer repairStageId;
}
