package org.belldj.mntest.supplier.domain;

import java.util.List;
import javax.inject.Singleton;
import javax.transaction.Transactional;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import io.micronaut.context.event.ApplicationEventPublisher;

@Singleton
public class SupplierService implements SupplierApi {

  @Mapper
  public interface SupplierServiceMappers {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    Supplier map(SupplierAddCommand command);
  }
 
  public static final SupplierServiceMappers mapper = Mappers.getMapper(SupplierServiceMappers.class);
  private final SupplierRespository repository;
  private ApplicationEventPublisher publisher;

  public SupplierService(SupplierRespository respository, ApplicationEventPublisher publisher) {
    this.repository = respository;
    this.publisher = publisher;
  }

  @Override
  public List<Supplier> findAll() {
    return repository.all();
  }

  @Transactional
  @Override
  public Supplier add(SupplierAddCommand command) {
    var part = mapper.map(command);
    part = repository.create(part);
    publisher.publishEvent(SupplierCreatedEvent.of(part));
    return part;
  }

}
