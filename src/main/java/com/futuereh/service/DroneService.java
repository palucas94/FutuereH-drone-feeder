package com.futuereh.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.futuereh.dto.DroneDto;
import com.futuereh.dto.UpdatedDroneDto;
import com.futuereh.entity.Drone;
import com.futuereh.repository.DroneRepository;

@ApplicationScoped
public class DroneService {

  @Inject
  private DroneRepository repository;
  
  public List<Drone> getAll() {
    return repository.listAll();
  }
  
  public Drone getDroneById(Long id) {
    return repository.findById(id);
  }
  
  @Transactional
  public void create(DroneDto droneDto) {
    Drone drone = new Drone();

    drone.setId(droneDto.getId());
    drone.setName(droneDto.getName());
    drone.setDroneStatus(droneDto.getDroneStatus());

    repository.persist(drone);
  }

  @Transactional
  public void update(UpdatedDroneDto droneDto, Long id) {
    Drone drone = repository.findById(id);
 
    drone.setName(droneDto.getName());
    drone.setDroneStatus(droneDto.getDroneStatus());
    
    repository.persist(drone);
  }
  
  @Transactional
  public void delete(Long id) {
    repository.deleteById(id);
  }
}
