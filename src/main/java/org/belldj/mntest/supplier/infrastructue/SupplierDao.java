package org.belldj.mntest.supplier.infrastructue;

import java.util.List;
import java.util.UUID;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface SupplierDao extends CrudRepository<SupplierE, UUID> {

  @Override
  @Query(value = "from SupplierE as s")
  List<SupplierE> findAll(); // empty

}

