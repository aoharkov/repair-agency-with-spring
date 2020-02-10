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
@Table(name = "repair_stages")
public class RepairStageEntity {
    @Id
    @Column(name = "id")
    private final Integer id;

    @Column(name = "name")
    private final String name;
}
