package org.belldj.mntest.user.web;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.constraints.NotNull;
import org.belldj.mntest.candidate.domain.Candidate;
import org.belldj.mntest.user.domain.User;
import org.belldj.mntest.user.domain.UserService;
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

@Controller(value = "/users", produces = MediaType.APPLICATION_JSON)
@Tag(name = "users")
@Validated
public class UserController {

  @Mapper(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
  public interface UserControllerMapper {
    UserT map(User part);
  }

  public static final UserControllerMapper mapper = Mappers.getMapper(UserControllerMapper.class);
 
  private UserService service;

  public UserController(UserService service) {
    this.service = service;
  }
 
  @Post(uri = "/")
  public HttpResponse<UserT> add(@Body @NotNull final UserAddCommandT command) {
    User part = service.add(command);
    return HttpResponse.created(mapper.map(part));
  }

  @Get(uri = "/")
  public HttpResponse<List<UserT>> all() {
    List<UserT> result = service.findAll().stream().map(mapper::map).collect(Collectors.toList());
    return HttpResponse.ok(result);
  }

}
