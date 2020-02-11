package aoharkov.training.repairagency.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@Table(name = "repair_stages")
public class RepairStageEntity {
    @Id
    @Column(name = "id", nullable = false)
    private final Integer id;

    @Column(name = "name", nullable = false)
    private final String name;
}
