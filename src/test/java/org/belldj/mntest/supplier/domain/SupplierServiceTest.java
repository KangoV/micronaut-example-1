package org.belldj.mntest.supplier.domain;

import static org.assertj.core.api.Assertions.assertThat;
import javax.inject.Inject;
import org.belldj.mntest.supplier.web.SupplierAddCommandT;
import org.junit.jupiter.api.Test;
import io.micronaut.test.annotation.MicronautTest;

@MicronautTest
class SupplierServiceTest {

  @Inject
  private SupplierService service;

  @Test
  void test_add() {

    var cmd = SupplierAddCommandT.builder()
      .name("main")
      .build();

    Supplier part = service.add(cmd);

    assertThat(part).isNotNull();
    
  }

  @Test
  void test_findAll() {
    var parts = service.findAll();
    assertThat(parts).isNotNull();
  }

}
