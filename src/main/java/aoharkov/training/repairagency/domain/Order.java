package aoharkov.training.repairagency.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Integer id;

    @NotNull
    private Request request;

    @NotNull
    private User manager;


    private Integer price;

    @NotNull
    private User master;

    @NotNull
    private RepairStage repairStage;
}
