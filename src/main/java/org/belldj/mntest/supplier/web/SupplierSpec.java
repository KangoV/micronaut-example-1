package org.belldj.mntest.supplier.web;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;
import org.belldj.mntest.shared.Type;
import org.belldj.mntest.shared.Category;
import org.belldj.mntest.util.JsonRawValueDeserializer;
import org.belldj.mntest.web.Transport;
import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.v3.oas.annotations.media.Schema;

@Transport
@Value.Immutable
@JsonSerialize(as = SupplierT.class)
@JsonDeserialize(as = SupplierT.class)
@JsonInclude(Include.NON_NULL)
@Schema(name = "Supplier", description = "The Supplier")
public interface SupplierSpec {

  UUID getId();

  String getName();

  LocalDateTime getCreatedDate();

}