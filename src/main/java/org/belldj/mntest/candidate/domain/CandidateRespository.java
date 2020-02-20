package org.belldj.mntest.candidate.domain;

import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.transaction.Transactional;
import org.belldj.mntest.candidate.infra.CandidateDao;
import org.belldj.mntest.candidate.infra.CandidateE;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import io.micronaut.context.event.ApplicationEventPublisher;

@Singleton
public class CandidateRespository {

  @Mapper
  public interface PartRepositoryMapper {
    Candidate  map(CandidateE src);
    CandidateE map(Candidate src);
    CandidateE map(Candidate src, @MappingTarget CandidateE target);
  }

  public static final PartRepositoryMapper mapper = Mappers.getMapper(PartRepositoryMapper.class);

  private final CandidateDao partDao;
  private final ApplicationEventPublisher eventBus;

  @Inject
  public CandidateRespository(CandidateDao partDao, ApplicationEventPublisher eventBus) {
    this.partDao = partDao;
    this.eventBus = eventBus;
  }

  @Transactional
  public Candidate create(Candidate part) {
    if (partDao.existsById(part.getId())) {
      throw new CandidateException(String.format("Part with id \"%s\" already exists", part.getId()));
    }
    var parte = partDao.save(mapper.map(part));
    var result = mapper.map(parte);
    eventBus.publishEvent(CandidateCreatedEvent.of(part));
    return result;
  }

  public List<Candidate> all() {
    return partDao
        .findAll()
        .stream()
        .map(mapper::map).collect(Collectors.toList());
  }

}
