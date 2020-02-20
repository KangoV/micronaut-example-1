package org.belldj.mntest.supplier.web;

import org.belldj.mntest.supplier.domain.SupplierApi;
import org.belldj.mntest.web.Transport;
import org.immutables.value.Value;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.v3.oas.annotations.media.Schema;

@Transport
@Value.Immutable
@JsonSerialize(as = SupplierAddCommandT.class)
@JsonDeserialize(as = SupplierAddCommandT.class)
@Schema(name = "AddSupplierCommand", description = "The Supplier to be added")
public interface SupplierAddCommandSpec extends SupplierApi.SupplierAddCommand {
}