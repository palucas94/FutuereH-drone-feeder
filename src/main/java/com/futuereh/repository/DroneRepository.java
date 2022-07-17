package com.futuereh.repository;

import com.futuereh.entity.Drone;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class DroneRepository implements PanacheRepositoryBase<Drone, Long>{
 
}
