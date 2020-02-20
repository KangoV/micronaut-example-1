package org.belldj.mntest.candidate.web;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.constraints.NotNull;
import org.belldj.mntest.candidate.domain.Candidate;
import org.belldj.mntest.candidate.domain.CandidateService;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.validation.Validated;
import io.swagger.v3.oas.annotations.tags.Tag;

@Controller(value = "/candidates", produces = MediaType.APPLICATION_JSON)
@Tag(name = "candidates")
@Validated
public class CandidateController {

  @Mapper(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
  public interface CandidateControllerMapper { 
    CandidateT map(Candidate part);
  }

  public static final CandidateControllerMapper mapper = Mappers.getMapper(CandidateControllerMapper.class);

  private CandidateService service;

  public CandidateController(CandidateService service) {
    this.service = service;
  }

  @Post(uri = "/")
  public HttpResponse<CandidateT> add(@Body @NotNull final CandidateAddCommandT command) {
    Candidate candidate = service.add(command);
    return HttpResponse.created(mapper.map(candidate));
  }

  @Get(uri = "/")
  public HttpResponse<List<CandidateT>> all() {
    List<CandidateT> result = service.findAll().stream().map(mapper::map).collect(Collectors.toList());
    return HttpResponse.ok(result);
  }

}
