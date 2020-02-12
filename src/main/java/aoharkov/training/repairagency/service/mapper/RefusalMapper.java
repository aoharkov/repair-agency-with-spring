package aoharkov.training.repairagency.service.mapper;

import aoharkov.training.repairagency.domain.Refusal;
import aoharkov.training.repairagency.domain.Request;
import aoharkov.training.repairagency.domain.User;
import aoharkov.training.repairagency.entity.RefusalEntity;
import aoharkov.training.repairagency.entity.RequestEntity;
import aoharkov.training.repairagency.entity.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("refusalMapper")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RefusalMapper implements Mapper<RefusalEntity, Refusal> {
    @Qualifier("requestMapper")
    private Mapper<RequestEntity, Request> requestMapper;
    @Qualifier("userMapper")
    private Mapper<UserEntity, User> userMapper;

    @Override
    public RefusalEntity mapDomainToEntity(Refusal refusal) {
        if (refusal == null) {
            return null;
        }
        RefusalEntity refusalEntity = new RefusalEntity();
        refusalEntity.setId(refusal.getId());
        refusalEntity.setRequest(requestMapper.mapDomainToEntity(refusal.getRequest()));
        refusalEntity.setExplanation(refusal.getExplanation());
        refusalEntity.setManager(userMapper.mapDomainToEntity(refusal.getManager()));
        return refusalEntity;
    }

    @Override
    public Refusal mapEntityToDomain(RefusalEntity refusalEntity) {
        if (refusalEntity == null) {
            return null;
        }
        return Refusal.builder()
                .id(refusalEntity.getId())
                .explanation(refusalEntity.getExplanation())
                .manager(userMapper.mapEntityToDomain(refusalEntity.getManager()))
                .request(requestMapper.mapEntityToDomain(refusalEntity.getRequest()))
                .build();
    }
}
