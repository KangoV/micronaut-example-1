package org.belldj.mntest.supplier.domain;

import static java.util.Objects.requireNonNullElseGet;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import com.fasterxml.uuid.Generators;

public final class Supplier {

  private static final String NULL_NAME = "A supplier must have a name";
  
  public static Supplier.Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    
    private UUID id;
    private String name;
    private LocalDateTime createdDate;

    public Supplier.Builder id(UUID id)                        { this.id = id; return this; }
    public Supplier.Builder name(String name)                  { this.name = name; return this; }
    public Supplier.Builder createdDate(LocalDateTime created) { this.createdDate = created; return this; }

    public Supplier build() {
      Objects.requireNonNull(NULL_NAME);
      return new Supplier(this);
    }

  }

  private final UUID id;
  private final String name;
  private final LocalDateTime createdDate;

  private Supplier(Supplier.Builder b) {
    assert b.name != null : NULL_NAME;
    this.id          = requireNonNullElseGet(b.id, Generators.timeBasedGenerator()::generate);
    this.name        = b.name;
    this.createdDate = requireNonNullElseGet(b.createdDate, LocalDateTime::now);
  }

  public UUID getId()                       { return this.id; }
  public String getName()                   { return this.name;  }
  public LocalDateTime getCreatedDate()     { return this.createdDate; }


  @Override
  public String toString() {
    return "Supplier [id=" + id + ", name=" + name + ", createdDate=" + createdDate + "]";
  }

  @Override
  public int hashCode() {
    return Objects.hash(createdDate, id, name);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Supplier other = (Supplier) obj;
    return Objects.equals(createdDate, other.createdDate) && Objects.equals(id, other.id) && Objects.equals(name, other.name);
  }

}
