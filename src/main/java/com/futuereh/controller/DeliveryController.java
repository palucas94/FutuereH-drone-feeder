package com.futuereh.controller;

import java.util.List;

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

import com.futuereh.dto.DeliveryDto;
import com.futuereh.entity.Delivery;
import com.futuereh.service.DeliveryService;

@Path("/delivery")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DeliveryController {
  
  @Inject
  private DeliveryService service;
  
  @GET
  public List<Delivery> getAll() {
    return service.getAll();
  }
  
  @GET
  @Path("/{id}")
  public Delivery getDeliveryById(Long id) {
    return service.getDeliveryById(id);
  }
  
  @POST
  public void create(DeliveryDto deliveryDto) {       
    service.create(deliveryDto);
  }
  
  @PATCH
  @Path("/{id}")
  public void update(@PathParam("id") Long id, DeliveryDto deliveryDto) {
    service.update(deliveryDto, id);
  }
  
  @DELETE
  @Path("/{id}")
  public void delete(@PathParam("id") Long id) {
    service.delete(id);
  }
}
