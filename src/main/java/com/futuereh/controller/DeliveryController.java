package com.futuereh.controller;

import javax.inject.Inject;
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

import com.futuereh.dto.DeliveryDto;
import com.futuereh.service.DeliveryService;

@Path("/delivery")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DeliveryController {
  
  @Inject
  private DeliveryService service;
  
  @GET
  public Response getAll() {
    return Response.ok().entity(service.getAll()).build();
  }
  
  @GET
  @Path("/{id}")
  public Response getDeliveryById(Long id) {
    return Response.ok().entity(service.getDeliveryById(id)).build();
  }
  
  @POST
  public Response create(DeliveryDto deliveryDto) {       
    return Response
        .status(201)
        .entity(service.create(deliveryDto))
        .build();
  }
  
  @PATCH
  @Path("/{id}")
  public Response update(@PathParam("id") Long id, DeliveryDto deliveryDto) {
    return Response
        .ok()
        .entity(service.update(deliveryDto, id))
        .build();
  }
  
  @DELETE
  @Path("/{id}")
  public Response delete(@PathParam("id") Long id) {
    service.delete(id);
    return Response.ok().build();
  }
}
