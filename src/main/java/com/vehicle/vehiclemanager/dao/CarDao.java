package com.vehicle.vehiclemanager.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vehicle.vehiclemanager.entity.Car;

@Repository
public interface CarDao extends JpaRepository<Car, Integer> {
	
}
