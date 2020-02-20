package org.belldj.mntest.user.domain;

import java.util.List;
import javax.inject.Singleton;
import javax.transaction.Transactional;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import io.micronaut.context.event.ApplicationEventPublisher;

@Singleton
public class UserService implements UserApi {

  @Mapper
  public interface UserServiceMappers {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    User map(UserAddCommand command); 
  }

  public static final UserServiceMappers mapper = Mappers.getMapper(UserServiceMappers.class);
  private final UserRespository repository;
  private ApplicationEventPublisher publisher;

  public UserService(UserRespository respository, ApplicationEventPublisher publisher) {
    this.repository = respository;
    this.publisher = publisher;
  }

  @Override
  public List<User> findAll() {
    return repository.all();
  }

  @Transactional
  @Override
  public User add(UserAddCommand command) {
    var part = mapper.map(command);
    part = repository.create(part);
    publisher.publishEvent(UserCreatedEvent.of(part));
    return part;
  }

}
