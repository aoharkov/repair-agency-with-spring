package aoharkov.training.repairagency.mapper;

import aoharkov.training.repairagency.domain.Request;
import aoharkov.training.repairagency.domain.User;
import aoharkov.training.repairagency.entity.RequestEntity;
import org.springframework.stereotype.Component;

@Component
public class RequestMapper implements Mapper<RequestEntity, Request> {

    @Override
    public RequestEntity mapDomainToEntity(Request item) {
        return new RequestEntity(
                item.getId(),
                item.getClient().getId(),
                item.getDescription(),
                item.getViewed(),
                item.getAccepted());
    }

    @Override
    public Request mapEntityToDomain(RequestEntity entity) {
        return Request.builder()
                .id(entity.getId())
                .description(entity.getDescription())
                .client(User.builder().id(entity.getClientId()).build())
                .viewed(entity.getViewed())
                .accepted(entity.getAccepted())
                .build();
    }
}
