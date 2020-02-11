package aoharkov.training.repairagency.service.mapper;

import aoharkov.training.repairagency.domain.Request;
import aoharkov.training.repairagency.domain.User;
import aoharkov.training.repairagency.entity.RequestEntity;
import org.springframework.stereotype.Component;

@Component
public class RequestMapper implements Mapper<RequestEntity, Request> {

    @Override
    public RequestEntity mapDomainToEntity(Request request) {
        return new RequestEntity(
                request.getId(),
                request.getClient().getId(),
                request.getDescription(),
                request.getViewed(),
                request.getAccepted());
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
