package org.belldj.mntest.candidate.web;

import org.belldj.mntest.candidate.domain.CandidateApi;
import org.belldj.mntest.web.Transport;
import org.immutables.value.Value;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.v3.oas.annotations.media.Schema;

@Transport
@Value.Immutable
@JsonSerialize(as = CandidateRelT.class)
@JsonDeserialize(as = CandidateRelT.class)
@Schema(name = "Part ref", description = "A relation for a part")
public interface CandidateRelSpec extends CandidateApi.PartRef {
}