/**
 *
 */
package org.belldj.mntest.supplier.domain;

import org.belldj.mntest.util.Event;
import org.immutables.value.Value;

@Event
@Value.Immutable(builder = false)
public interface SupplierCreatedEventSpec { 
  @Value.Parameter(order = 1)
  Supplier getUser();
}
