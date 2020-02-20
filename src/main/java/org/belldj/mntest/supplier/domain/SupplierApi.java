package org.belldj.mntest.supplier.domain;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.belldj.mntest.shared.Type;

public interface SupplierApi {

  public interface SupplierAddCommand {
    String getName();
  }

  Supplier add(SupplierAddCommand build);
  List<Supplier> findAll();

}
