package aoharkov.training.repairagency.mapper;

import aoharkov.training.repairagency.domain.Request;
import aoharkov.training.repairagency.domain.User;
import aoharkov.training.repairagency.entity.RequestEntity;

public class RequestMapper implements Mapper<RequestEntity, Request> {

    @Override
    public RequestEntity mapDomainToEntity(Request item) {
        return RequestEntity.builder()
                .id(item.getId())
                .description(item.getDescription())
                .clientId(item.getClient().getId())
                .viewed(item.getViewed())
                .accepted(item.getAccepted())
                .build();
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
