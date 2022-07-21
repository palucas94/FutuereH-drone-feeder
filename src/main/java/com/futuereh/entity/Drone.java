package com.futuereh.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Drone {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  private String name;
  
  private String droneStatus;
  
  @OneToMany(mappedBy = "droneId", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Delivery> deliveries;

  public Drone() {};
  
  public Drone(Long id, String name, String droneStatus, List<Delivery> deliveries) {
    super();
    this.id = id;
    this.name = name;
    this.droneStatus = droneStatus;
    this.deliveries = new ArrayList<Delivery>();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDroneStatus() {
    return droneStatus;
  }

  public void setDroneStatus(String droneStatus) {
    this.droneStatus = droneStatus;
  }

  public List<Delivery> getDeliveries() {
    return deliveries;
  }

  public void setDeliveries(List<Delivery> deliveries) {
    this.deliveries = deliveries;
  }

  public void addDeliveries(Delivery delivery) {
    this.deliveries.add(delivery);
  }
}
