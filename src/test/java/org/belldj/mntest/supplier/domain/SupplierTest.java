package org.belldj.mntest.supplier.domain;

import static org.assertj.core.api.Assertions.assertThat;
import java.time.LocalDateTime;
import java.util.UUID;
import org.belldj.mntest.supplier.web.SupplierAddCommandT;
import org.belldj.mntest.supplier.web.SupplierController;
import org.belldj.mntest.supplier.web.SupplierT;
import org.belldj.mntest.util.JacksonModule;
import org.junit.jupiter.api.Test;
import com.fasterxml.jackson.databind.ObjectMapper;

class SupplierTest {

  private UUID PART_ID = UUID.randomUUID();
  private LocalDateTime NOW = LocalDateTime.now();

  @SuppressWarnings("preview")
  private static final String DATA =
    """
    { 
      "code": "CHRY"
    }
    """;

  
  @Test
  void test_AddPartCommand() {

    var part = SupplierAddCommandT.builder()
      .name("Cherry")
      .build();
    
    assertThat(part).isNotNull();
    
  }

  @Test
  void testPart() {
    var part = SupplierT.builder()
      .id(PART_ID)
      .name("Cherry")
      .createdDate(LocalDateTime.now())
      .build();
    assertThat(part).isNotNull();
  }

  @Test
  void test_map_from_Part_to_PartT() {

    var part = Supplier.builder()
      .id(PART_ID)
      .name("darren")
      .createdDate(NOW)
      .build();
    assertThat(part).isNotNull();

    var part_t = SupplierController.mapper.map(part);
    
    assertThat(part_t).isEqualTo(SupplierT.builder()
      .id(PART_ID)
      .name("darren")
      .createdDate(NOW).build());

  }

  @SuppressWarnings("preview")
  @Test
  void test_deserialise_into_SupplierT() throws Exception {

    var supplier_json = 
        """
        {
          "name": "Company"
        }
        """;

    var mapper = new ObjectMapper();

    mapper.registerModule(new JacksonModule());

    var supplier_t = mapper.readValue(supplier_json, SupplierAddCommandT.class);
    var expected_supplier_t = SupplierAddCommandT.builder().name("Company").build();
    
    assertThat(supplier_t).isEqualTo(expected_supplier_t);
    
  }

}
