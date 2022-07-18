package com.futuereh.controller;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.futuereh.dto.DroneDto;
import com.futuereh.dto.UpdatedDroneDto;
import com.futuereh.service.DroneService;

@Path("/drone")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DroneController {
  
  @Inject
  private DroneService service;

  @GET
  public Response findAll() {
    return Response.ok().entity(service.getAll()).build();
  }

  @GET
  @Path("/{id}")
  public Response getDroneById(@PathParam("id") Long id) {
    return Response.ok().entity(service.getDroneById(id)).build();
  }

  @Transactional
  @POST
  public Response create(DroneDto drone) {
    return Response
        .status(201)
        .entity(service.create(drone))
        .build();
  }

  @PATCH
  @Path("/{id}")
  public Response update(@PathParam("id") Long id, UpdatedDroneDto droneDto) {
    return Response
        .ok()
        .entity(service.update(droneDto, id))
        .build();
  }

  @DELETE
  @Path("/{id}")
  public Response delete(@PathParam("id") Long id) {
    service.delete(id);
    return Response.ok().build();
  }
}
