package com.vehicle.vehiclemanager.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicle.vehiclemanager.dao.CarDao;
import com.vehicle.vehiclemanager.entity.Car;

@Service
public class CarServiceImpl implements CarService {
	
	@Autowired
	private CarDao carDao;
	
	@Override
	public Car addCar(Car car) {
		this.carDao.save(car);
		return car;
	}

	@Override
	public Car getCarById(Integer carId) {
		Optional<Car> car = carDao.findById(carId);
		if(car.isPresent()) {
			return car.get();
		}else {
			throw new RuntimeException("car ID not found.");
		}
//		return this.carDao.getById(carId);
	}

	@Override
	public Car updateCar(Car car, Integer carId) {
		Optional<Car> cars = carDao.findById(carId);
		if(cars.isPresent()) {
			carDao.save(cars.get());
			return car;
		}else {
			throw new RuntimeException("car ID not found.");
		}
	}

	@Override
	public Boolean deleteCarById(Integer carId) {
		Optional<Car> cars = carDao.findById(carId);
		if(cars.isPresent()) {
			carDao.delete(cars.get());
			return true;
		}else {
			throw new RuntimeException("car ID not found.");
		}
	}

}
