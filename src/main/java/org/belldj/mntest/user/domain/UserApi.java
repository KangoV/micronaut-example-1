package org.belldj.mntest.user.domain;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.belldj.mntest.shared.Type;

public interface UserApi {

  public interface UserAddCommand {
    String getName();
  }

  User add(UserAddCommand build);
  List<User> findAll();

}
