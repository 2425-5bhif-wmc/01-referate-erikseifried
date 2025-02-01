package at.htl.resource;

import at.htl.boundary.VehicleRepository;
import at.htl.entity.Vehicle;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/vehicles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VehicleResource {

    @Inject
    VehicleRepository vehicleRepository;

    @GET
    public List<Vehicle> getAll() {
        return vehicleRepository.listAll();
    }

    @GET
    @Path("/{id}")
    public Response getVehicleById(@PathParam("id") Long id) {
        Vehicle vehicle = vehicleRepository.findById(id);
        if (vehicle == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(vehicle).build();
    }

    @POST
    @Transactional
    public Response createVehicle(Vehicle vehicle) {
        vehicleRepository.persist(vehicle);
        return Response.status(Response.Status.CREATED).entity(vehicle).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response updateVehicle(@PathParam("id") Long id, Vehicle updatedVehicle) {
        Vehicle vehicle = vehicleRepository.findById(id);
        if (vehicle == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        vehicle.setName(updatedVehicle.getName());
        vehicle.setType(updatedVehicle.getType());
        return Response.ok(vehicle).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteVehicle(@PathParam("id") Long id) {
        Vehicle vehicle = vehicleRepository.findById(id);
        if (vehicle == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        vehicleRepository.delete(vehicle);
        return Response.noContent().build();
    }
}
