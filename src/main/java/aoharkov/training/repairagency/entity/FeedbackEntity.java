package aoharkov.training.repairagency.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@Table(name = "feedback")
public class FeedbackEntity {
    @Id
    @Column(name = "id", nullable = false)
    private final Integer id;

    @OneToOne
    @JoinColumn(name = "request_id", nullable = false)
    private final Integer requestId;

    @Column(name = "text")
    private final String text;

    @Column(name = "score")
    private final Integer score;
}
