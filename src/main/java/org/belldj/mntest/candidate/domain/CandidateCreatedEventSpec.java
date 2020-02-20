/**
 *
 */
package org.belldj.mntest.candidate.domain;

import org.belldj.mntest.util.Event;
import org.immutables.value.Value;

@Event
@Value.Immutable(builder = false)
public interface CandidateCreatedEventSpec { 
  @Value.Parameter(order = 1)
  Candidate getPart();
}
