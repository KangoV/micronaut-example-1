/**
 *
 */
package org.belldj.mntest.user.domain;

import org.belldj.mntest.util.Event;
import org.immutables.value.Value;

@Event
@Value.Immutable(builder = false)
public interface UserCreatedEventSpec { 
  @Value.Parameter(order = 1)
  User getUser();
}
