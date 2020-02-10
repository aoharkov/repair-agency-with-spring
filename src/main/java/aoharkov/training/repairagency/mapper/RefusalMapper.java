package aoharkov.training.repairagency.mapper;

import aoharkov.training.repairagency.domain.Refusal;
import aoharkov.training.repairagency.domain.Request;
import aoharkov.training.repairagency.domain.User;
import aoharkov.training.repairagency.entity.RefusalEntity;

public class RefusalMapper implements Mapper<RefusalEntity, Refusal> {

    @Override
    public RefusalEntity mapDomainToEntity(Refusal item) {
        return RefusalEntity.builder()
                .id(item.getId())
                .explanation(item.getExplanation())
                .managerId(item.getManager().getId())
                .requestId(item.getRequest().getId())
                .build();
    }

    @Override
    public Refusal mapEntityToDomain(RefusalEntity entity) {
        return Refusal.builder()
                .id(entity.getId())
                .explanation(entity.getExplanation())
                .manager(User.builder().id(entity.getManagerId()).build())
                .request(Request.builder().id(entity.getRequestId()).build())
                .build();
    }
}
