package aoharkov.training.repairagency.service.mapper;

import aoharkov.training.repairagency.domain.Request;
import aoharkov.training.repairagency.domain.User;
import aoharkov.training.repairagency.entity.RequestEntity;
import aoharkov.training.repairagency.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("requestMapper")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RequestMapper implements Mapper<RequestEntity, Request> {
    @Qualifier("userMapper")
    private Mapper<UserEntity, User> userMapper;

    @Override
    public RequestEntity mapDomainToEntity(Request request) {
        if (request == null) {
            return null;
        }
        RequestEntity requestEntity = new RequestEntity();
        requestEntity.setId(request.getId());
        requestEntity.setClient(userMapper.mapDomainToEntity(request.getClient()));
        requestEntity.setDescription(request.getDescription());
        requestEntity.setViewed(request.getViewed());
        requestEntity.setAccepted(request.getAccepted());
        return requestEntity;
    }

    @Override
    public Request mapEntityToDomain(RequestEntity requestEntity) {
        if (requestEntity == null) {
            return null;
        }
        return Request.builder()
                .id(requestEntity.getId())
                .description(requestEntity.getDescription())
                .client(userMapper.mapEntityToDomain(requestEntity.getClient()))
                .viewed(requestEntity.getViewed())
                .accepted(requestEntity.getAccepted())
                .build();
    }
}
