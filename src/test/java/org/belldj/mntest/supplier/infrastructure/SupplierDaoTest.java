package org.belldj.mntest.supplier.infrastructure;

import static org.assertj.core.api.Assertions.assertThat;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import javax.inject.Inject;
import org.belldj.mntest.shared.Type;
import org.belldj.mntest.candidate.infra.CandidateDao;
import org.belldj.mntest.candidate.infra.CandidateE;
import org.belldj.mntest.shared.Category;
import org.junit.jupiter.api.Test;
import io.micronaut.test.annotation.MicronautTest;

@MicronautTest
class SupplierDaoTest {

  private static final UUID ID = UUID.randomUUID();
  
  @Inject
  private CandidateDao dao;

  @Test
  void test() {

    var p = new CandidateE();
    
    p.setId(ID);
    p.setCreatedDate(LocalDateTime.now());
    p.setName("Cherry");

    p = dao.save(p);
    
    assertThat(p).isNotNull();
    
    var opt = dao.findById(ID);
    
    assertThat(opt.isPresent()).isTrue();
    
  }

}
