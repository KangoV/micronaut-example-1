package org.belldj.mntest.candidate.domain;

import java.util.List;
import javax.inject.Singleton;
import javax.transaction.Transactional;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import io.micronaut.context.event.ApplicationEventPublisher;

@Singleton
public class CandidateService implements CandidateApi {

  @Mapper
  public interface PartServiceMappers {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "category", source = "type.category")
    Candidate map(PartAddCommand command);
  }

  public static final PartServiceMappers mapper = Mappers.getMapper(PartServiceMappers.class);
  private final CandidateRespository repository;
  private ApplicationEventPublisher publisher;

  public CandidateService(CandidateRespository respository, ApplicationEventPublisher publisher) {
    this.repository = respository;
    this.publisher = publisher;
  }

  @Override
  public List<Candidate> findAll() {
    return repository.all();
  }

  @Transactional
  @Override
  public Candidate add(PartAddCommand command) {
    var part = mapper.map(command);
    part = repository.create(part);
    publisher.publishEvent(CandidateCreatedEvent.of(part));
    return part;
  }

}
