package org.belldj.mntest.user.domain;

import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.transaction.Transactional;
import org.belldj.mntest.candidate.infra.CandidateDao;
import org.belldj.mntest.candidate.infra.CandidateE;
import org.belldj.mntest.user.infra.UserDao;
import org.belldj.mntest.user.infra.UserE;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import io.micronaut.context.event.ApplicationEventPublisher;

@Singleton
public class UserRespository {

  @Mapper
  public interface PartRepositoryMapper {
    User  map(UserE src);
    UserE map(User src);
    UserE map(User src, @MappingTarget UserE target);
  }

  public static final PartRepositoryMapper mapper = Mappers.getMapper(PartRepositoryMapper.class);

  private final UserDao userDao;
  private final ApplicationEventPublisher eventBus;

  @Inject
  public UserRespository(UserDao userDao, ApplicationEventPublisher eventBus) {
    this.userDao = userDao;
    this.eventBus = eventBus;
  }

  @Transactional
  public User create(User part) {
    if (userDao.existsById(part.getId())) {
      throw new UserException(String.format("Part with id \"%s\" already exists", part.getId()));
    }
    var parte = userDao.save(mapper.map(part));
    var result = mapper.map(parte);
    eventBus.publishEvent(UserCreatedEvent.of(part));
    return result;
  }

  public List<User> all() {
    return userDao
        .findAll()
        .stream()
        .map(mapper::map).collect(Collectors.toList());
  }

}
