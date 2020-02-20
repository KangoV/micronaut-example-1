package org.belldj.mntest.user.web;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.constraints.NotNull;
import org.belldj.mntest.candidate.domain.Candidate;
import org.belldj.mntest.candidate.domain.CandidateService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
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

@Controller(value = "/users", produces = MediaType.APPLICATION_JSON)
@Tag(name = "parts")
@Validated
public class UserController {

  @Mapper(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
  public interface PartControllerMapper {
    UserT map(Candidate part);
  }

  public static final PartControllerMapper mapper = Mappers.getMapper(PartControllerMapper.class);

  private CandidateService service;

  public UserController(CandidateService service) {
    this.service = service;
  }

  /**
   * Registers a new build
   *
   * @param build The build to register
   * @return The build that was saved
   */
  @Post(uri = "/")
  public HttpResponse<UserT> add(@Body @NotNull final UserAddCommandT command) {
    Candidate part = service.add(command);
    return HttpResponse.created(mapper.map(part));
  }

  /**
   * Returns all registered builds
   *
   * @return all registered builds
   */
  @Get(uri = "/")
  public HttpResponse<List<UserT>> all() {
    List<UserT> result = service.findAll().stream().map(mapper::map).collect(Collectors.toList());
    return HttpResponse.ok(result);
  }

}
