package org.belldj.mntest.user.web;

import org.belldj.mntest.candidate.domain.CandidateApi;
import org.belldj.mntest.util.JsonRawValueDeserializer;
import org.belldj.mntest.web.Transport;
import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.v3.oas.annotations.media.Schema;

@Transport
@Value.Immutable
@JsonSerialize(as = UserAddCommandT.class)
@JsonDeserialize(as = UserAddCommandT.class)
@Schema(name = "AddPartCommand", description = "The part to be added")
public interface UserAddCommandSpec extends CandidateApi.PartAddCommand {
}