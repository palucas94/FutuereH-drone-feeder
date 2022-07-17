package com.futuereh.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.futuereh.dto.DeliveryDto;
import com.futuereh.entity.Delivery;
import com.futuereh.repository.DeliveryRepository;


@ApplicationScoped
public class DeliveryService {

  @Inject
  private DeliveryRepository repository;
  
  public List<Delivery> getAll() {
    return repository.listAll();
  }
  
  public Delivery getDeliveryById(Long id) {
    return repository.findById(id);
  }
  
  @Transactional
  public void create(DeliveryDto deliveryDto) {
    Delivery delivery = new Delivery();
    
    delivery.setLat(deliveryDto.getLat());
    delivery.setLon(deliveryDto.getLon());
    delivery.setPostingDate(deliveryDto.getPostingDate());
    delivery.setDeliveryDate(deliveryDto.getDeliveryDate());
    delivery.setDeliveryStatus(deliveryDto.getDeliveryStatus());
    
    repository.persist(delivery);
  }
  
  @Transactional
  public void update(DeliveryDto deliveryDto, Long id) {
    Delivery delivery = repository.findById(id);
    
    delivery.setLat(deliveryDto.getLat());
    delivery.setLon(deliveryDto.getLon());
    delivery.setPostingDate(deliveryDto.getPostingDate());
    delivery.setDeliveryDate(deliveryDto.getDeliveryDate());
    delivery.setDeliveryStatus(deliveryDto.getDeliveryStatus());
    
    repository.persist(delivery);
  }
  
  @Transactional
  public void delete(Long id) {
    repository.deleteById(id);
  }
}
