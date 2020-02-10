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
@Table(name = "refusals")
public class RefusalEntity {
    @Id
    @Column(name = "id")
    private final Integer id;

    @Column(name = "request_id")
    private final Integer requestId;

    @Column(name = "explanation")
    private final String explanation;

    @Column(name = "manager_id")
    private final Integer managerId;
}
