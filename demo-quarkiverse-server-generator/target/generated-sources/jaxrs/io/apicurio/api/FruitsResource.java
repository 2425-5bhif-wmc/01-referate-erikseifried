package io.apicurio.api;

import io.apicurio.api.beans.Fruit;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import java.util.List;

/**
 * A JAX-RS interface. An implementation of this interface must be provided.
 */
@Path("/fruits")
public interface FruitsResource {
  @GET
  @Produces("application/json")
  List<Fruit> getAllFruits();

  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Fruit addFruit(@NotNull Fruit data);
}
