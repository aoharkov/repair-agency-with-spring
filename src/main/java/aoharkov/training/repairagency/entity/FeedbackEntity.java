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
@Table(name = "feedback")
public class FeedbackEntity {
    @Id
    @Column(name = "id")
    private final Integer id;

    @Column(name = "requestId")
    private final Integer requestId;

    @Column(name = "text")
    private final String text;

    @Column(name = "score")
    private final Integer score;
}
