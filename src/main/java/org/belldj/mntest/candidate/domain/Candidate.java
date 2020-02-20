package org.belldj.mntest.candidate.domain;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.belldj.mntest.shared.Type;
import org.belldj.mntest.shared.Category;
import com.fasterxml.uuid.Generators;

public final class Candidate {

  public static Candidate.Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private UUID id;
    private Category category;
    private Type type;
    private String name;
    private String data;
    private Set<UUID> elements;
    private Map<String, String> properties;
    private LocalDateTime createdDate;

    public Candidate.Builder id(UUID id)                                { this.id = id; return this; }
    public Candidate.Builder category(Category category)                { this.category = category; return this; }
    public Candidate.Builder type(Type type)                            { this.type = type; return this; }
    public Candidate.Builder name(String name)                          { this.name = name; return this; }
    public Candidate.Builder data(String data)                          { this.data = data; return this; }
    public Candidate.Builder elements(Set<UUID> elements)               { this.elements = elements; return this; }
    public Candidate.Builder properties(Map<String, String> properties) { this.properties = properties; return this; }
    public Candidate.Builder createdDate(LocalDateTime created)         { this.createdDate = created; return this; }

    public Candidate build() {
      return new Candidate(this);
    }

  }

  private final UUID id;
  private final Category category;
  private final Type type;
  private final String name;
  private final String data;
  private final Set<UUID> elements;
  private final Map<String, String> properties;
  private final LocalDateTime createdDate;

  private Candidate(Candidate.Builder b) {
    this.id          = (b.id == null) ? Generators.timeBasedGenerator().generate() : b.id;
    this.type        = b.type;
    this.category    = b.category;
    this.name        = b.name;
    this.data        = b.data;
    this.elements    = (b.elements == null) ? new HashSet<>() : b.elements;
    this.properties  = (b.properties == null) ? new HashMap<>() : b.properties;
    this.createdDate = (b.createdDate == null) ? LocalDateTime.now() : b.createdDate;
  }

  public UUID getId()                       { return this.id; }
  public Category getCategory()             { return this.category; }
  public Type getType()                     { return this.type; }
  public String getName()                   { return this.name;  }
  public String getData()                   { return this.data;  }
  public Set<UUID> getElements()            { return this.elements; }
  public Map<String,String> getProperties() { return this.properties; }
  public LocalDateTime getCreatedDate()     { return this.createdDate; }

}
