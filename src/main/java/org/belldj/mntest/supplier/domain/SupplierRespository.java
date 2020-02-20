package org.belldj.mntest.supplier.domain;

import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.transaction.Transactional;
import org.belldj.mntest.supplier.infrastructue.SupplierDao;
import org.belldj.mntest.supplier.infrastructue.SupplierE;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import io.micronaut.context.event.ApplicationEventPublisher;

@Singleton
public class SupplierRespository {

  @Mapper
  public interface SupplierRepositoryMapper {
    Supplier  map(SupplierE src);
    SupplierE map(Supplier src);
    SupplierE map(Supplier src, @MappingTarget SupplierE target);
  }

  public static final SupplierRepositoryMapper mapper = Mappers.getMapper(SupplierRepositoryMapper.class);

  private final SupplierDao supplierDao;
  private final ApplicationEventPublisher eventBus;

  @Inject
  public SupplierRespository(SupplierDao userDao, ApplicationEventPublisher eventBus) {
    this.supplierDao = userDao;
    this.eventBus = eventBus;
  }

  @Transactional
  public Supplier create(Supplier supplier) {
    if (supplierDao.existsById(supplier.getId())) {
      throw new SupplierException(String.format("Supplier with id \"%s\" already exists", supplier.getId()));
    }
    var suppliere = supplierDao.save(mapper.map(supplier));
    var result = mapper.map(suppliere);
    eventBus.publishEvent(SupplierCreatedEvent.of(supplier));
    return result;
  }

  public List<Supplier> all() {
    return supplierDao
        .findAll()
        .stream()
        .map(mapper::map).collect(Collectors.toList());
  }

}
