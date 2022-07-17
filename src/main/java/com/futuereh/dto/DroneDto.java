package com.futuereh.dto;

public class DroneDto {
  private Long id;
  
  private String name;
  
  private String droneStatus;

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
  
}