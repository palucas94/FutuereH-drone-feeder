package com.futuereh.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Delivery {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String lat;
  
  private String lon;

  private String postingDate;
  
  private String deliveryDate;
  
  private String deliveryStatus;
  
  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "droneId")
  private Drone droneId;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getLat() {
    return lat;
  }

  public void setLat(String lat) {
    this.lat = lat;
  }

  public String getLon() {
    return lon;
  }

  public void setLon(String lon) {
    this.lon = lon;
  }

  public String getPostingDate() {
    return postingDate;
  }

  public void setPostingDate(String postingDate) {
    this.postingDate = postingDate;
  }

  public String getDeliveryDate() {
    return deliveryDate;
  }

  public void setDeliveryDate(String deliveryDate) {
    this.deliveryDate = deliveryDate;
  }

  public String getDeliveryStatus() {
    return deliveryStatus;
  }

  public void setDeliveryStatus(String deliveryStatus) {
    this.deliveryStatus = deliveryStatus;
  }

  public Drone getDroneId() {
    return droneId;
  }

  public void setDroneId(Drone droneId) {
    this.droneId = droneId;
  }
  
}
