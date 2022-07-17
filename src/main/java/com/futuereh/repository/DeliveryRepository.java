package com.futuereh.repository;

import javax.enterprise.context.ApplicationScoped;

import com.futuereh.entity.Delivery;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class DeliveryRepository implements PanacheRepositoryBase<Delivery, Long> {

}
