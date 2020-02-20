package org.belldj.mntest.supplier;

import java.time.LocalDateTime;
import java.util.UUID;
import org.assertj.core.api.Assertions;
import org.belldj.mntest.supplier.domain.Supplier;
import org.belldj.mntest.supplier.domain.SupplierRespository;
import org.belldj.mntest.supplier.infrastructue.SupplierE;
import org.junit.jupiter.api.Test;

class SupplierToFromSupplierEMappingTest {

  private UUID ID = UUID.randomUUID();
  private LocalDateTime NOW = LocalDateTime.now();

  @Test
  void test() {

    var original_part = Supplier.builder()
      .id(ID)
      .name("darren") 
      .createdDate(NOW)
      .build();

    SupplierE part_e = SupplierRespository.mapper.map(original_part);
    Supplier part = SupplierRespository.mapper.map(part_e);

    Assertions.assertThat(part).isEqualTo(original_part);

  }

}
