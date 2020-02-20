package org.belldj.mntest.supplier.web;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.constraints.NotNull;
import org.belldj.mntest.supplier.domain.Supplier;
import org.belldj.mntest.supplier.domain.SupplierService;
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

@Controller(value = "/suppliers", produces = MediaType.APPLICATION_JSON)
@Tag(name = "suppliers")
@Validated
public class SupplierController {

  @Mapper(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
  public interface SupplierControllerMapper { 
    SupplierT map(Supplier part);
  }

  public static final SupplierControllerMapper mapper = Mappers.getMapper(SupplierControllerMapper.class);

  private SupplierService service;

  public SupplierController(SupplierService service) {
    this.service = service;
  }

  /**
   * Registers a new build
   *
   * @param build The build to register
   * @return The build that was saved
   */
  @Post(uri = "/")
  public HttpResponse<SupplierT> add(@Body @NotNull final SupplierAddCommandT command) {
    Supplier part = service.add(command);
    return HttpResponse.created(mapper.map(part));
  }

  /**
   * Returns all registered builds
   *
   * @return all registered builds
   */
  @Get(uri = "/")
  public HttpResponse<List<SupplierT>> all() {
    List<SupplierT> result = service.findAll().stream().map(mapper::map).collect(Collectors.toList());
    return HttpResponse.ok(result);
  }

}
