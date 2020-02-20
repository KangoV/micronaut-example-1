package org.belldj.mntest.candidate.domain;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.belldj.mntest.shared.Type;

public interface CandidateApi {

  public interface PartAddCommand {
    Type getType();
    String getName();
    String getData();
    Set<UUID> getElements();
    Set<PartRef> getRelations();
    Map<String,String> properties();
  }

  public interface PartRef {
    Type getType();
    UUID getPartId();
  }

  Candidate add(PartAddCommand build);
  List<Candidate> findAll();

}
