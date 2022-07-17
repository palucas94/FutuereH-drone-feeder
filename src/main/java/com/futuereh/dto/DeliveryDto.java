package com.futuereh.dto;

public class DeliveryDto {

  private String lat;
  
  private String lon;
  
  private String postingDate;
  
  private String deliveryDate;
  
  private String deliveryStatus;

  private Long droneId;
  
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

  public void setDeliveryStatus(String status) {
    this.deliveryStatus = status;
  }

  public Long getDroneId() {
    return droneId;
  }

  public void setDroneId(Long droneId) {
    this.droneId = droneId;
  }

}
