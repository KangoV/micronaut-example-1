package org.belldj.mntest.candidate.web;

import java.time.LocalDateTime;
import java.util.UUID;
import org.belldj.mntest.web.Transport;
import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.v3.oas.annotations.media.Schema;

@Transport
@Value.Immutable
@JsonSerialize(as = CandidateT.class)
@JsonDeserialize(as = CandidateT.class)
@JsonInclude(Include.NON_NULL)
@Schema(name = "Candidate", description = "The Candidate")
public interface CandidateSpec {

  UUID getId();

  String getName();

  LocalDateTime getCreatedDate();

}