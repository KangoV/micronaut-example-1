package org.belldj.mntest.user.infra;

import java.util.List;
import java.util.UUID;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface UserDao extends CrudRepository<UserE, UUID> {

  @Override
  @Query(value = "from UserE as user")
  List<UserE> findAll(); // empty

}

