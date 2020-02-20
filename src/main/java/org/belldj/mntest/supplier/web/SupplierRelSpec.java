package org.belldj.mntest.supplier.web;

import org.belldj.mntest.candidate.domain.CandidateApi;
import org.belldj.mntest.web.Transport;
import org.immutables.value.Value;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.v3.oas.annotations.media.Schema;

@Transport
@Value.Immutable
@JsonSerialize(as = SupplierRelT.class)
@JsonDeserialize(as = SupplierRelT.class)
@Schema(name = "Part ref", description = "A relation for a part")
public interface SupplierRelSpec extends CandidateApi.PartRef {
}