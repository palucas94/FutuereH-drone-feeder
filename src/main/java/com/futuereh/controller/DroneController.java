package com.futuereh.controller;

import java.util.List;

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

import com.futuereh.dto.DroneDto;
import com.futuereh.dto.UpdatedDroneDto;
import com.futuereh.entity.Drone;
import com.futuereh.service.DroneService;

@Path("/drone")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DroneController {
  
  @Inject
  private DroneService service;

  @GET
  public List<Drone> findAll() {
    return service.getAll();
  }

  @GET
  @Path("/{id}")
  public Drone getDroneById(@PathParam("id") Long id) {
    return service.getDroneById(id);
  }

  @Transactional
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public void create(DroneDto drone) {
    service.create(drone);
  }

  @PATCH
  @Path("/{id}")
  public void update(@PathParam("id") Long id, UpdatedDroneDto droneDto) {
    service.update(droneDto, id);
  }

  @DELETE
  @Path("/{id}")
  public void delete(@PathParam("id") Long id) {
    service.delete(id);
  }
}
