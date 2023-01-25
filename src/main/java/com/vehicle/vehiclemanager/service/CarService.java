package com.vehicle.vehiclemanager.service;

import org.springframework.stereotype.Service;

import com.vehicle.vehiclemanager.entity.Car;

@Service
public interface CarService {
	
	public Car addCar(Car car);
	public Car getCarById(Integer carId);
	public Car updateCar(Car car, Integer carId);
	public Boolean deleteCarById(Integer carId);
}
