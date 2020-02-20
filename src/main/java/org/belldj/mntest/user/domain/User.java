package org.belldj.mntest.user.domain;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.belldj.mntest.shared.Type;
import org.belldj.mntest.shared.Category;
import com.fasterxml.uuid.Generators;

public final class User {

  public static User.Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private UUID id;
    private String name;
    private LocalDateTime createdDate;

    public User.Builder id(UUID id)                                { this.id = id; return this; }
    public User.Builder name(String name)                          { this.name = name; return this; }
    public User.Builder createdDate(LocalDateTime created)         { this.createdDate = created; return this; }

    public User build() {
      return new User(this);
    }

  }

  private final UUID id;
  private final String name;
  private final LocalDateTime createdDate;

  private User(User.Builder b) {
    this.id          = (b.id == null) ? Generators.timeBasedGenerator().generate() : b.id;
    this.name        = b.name;
    this.createdDate = (b.createdDate == null) ? LocalDateTime.now() : b.createdDate;
  }

  public UUID getId()                       { return this.id; }
  public String getName()                   { return this.name;  }
  public LocalDateTime getCreatedDate()     { return this.createdDate; }

}
