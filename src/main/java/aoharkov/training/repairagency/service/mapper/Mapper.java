package aoharkov.training.repairagency.service.mapper;

public interface Mapper<E, D> {

    E mapDomainToEntity(D item);

    D mapEntityToDomain(E entity);
}
