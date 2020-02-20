package org.belldj.mntest.candidate.infra;

import java.util.List;
import java.util.UUID;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface CandidateDao extends CrudRepository<CandidateE, UUID> {

  @Override
  @Query(value = "from PartE as part")
  List<CandidateE> findAll(); // empty

}

