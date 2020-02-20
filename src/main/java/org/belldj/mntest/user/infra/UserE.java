package org.belldj.mntest.user.infra;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;
import org.belldj.mntest.shared.Type;
import org.belldj.mntest.shared.Category;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "employee")
public final class UserE {

  @Id
  @Column(columnDefinition = "uuid", nullable = false, updatable = false)
  private UUID id;

  @Column(name = "name", nullable = true)
  private String name;

  @Column(name = "created", nullable = false, updatable = false)
  @CreationTimestamp
  private LocalDateTime createdDate;

  /*
   * ### ### getters/ setters ###
   */

  public LocalDateTime getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(LocalDateTime created) {
    this.createdDate = created;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
