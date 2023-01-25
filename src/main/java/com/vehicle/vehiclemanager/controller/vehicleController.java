package com.vehicle.vehiclemanager.controller;

import org.aspectj.apache.bcel.classfile.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vehicle.vehiclemanager.entity.Car;
import com.vehicle.vehiclemanager.service.CarService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(tags = "Vehicle Management")
public class vehicleController {
	
	@Autowired
	private CarService carService;
	
	@PostMapping("/cars")
	@ApiOperation(value = "Enter Car data", notes = "Enter new Car data", tags = {"Vehicle Management"})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Car data entered successfully"),
			@ApiResponse(code = 404, message = "Invalid Data used"),
			@ApiResponse(code = 500, message = "Internal server error")
	})
	public Car postCars(@RequestBody Car car) {
		
		return this.carService.addCar(car);
	}
	
	@GetMapping("/cars/{carId}")
	@ApiOperation(value = "Fetch Car data", notes = "Fetch Car data by Car ID", tags = {"Vehicle Management"})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Car data retrieved successfully"),
			@ApiResponse(code = 404, message = "Invalid Car ID"),
			@ApiResponse(code = 500, message = "Internal server error")
	})
	public Car getcar(@PathVariable Integer carId) {
		System.out.println("getCars");
		return this.carService.getCarById(carId);
	}
	
	@PutMapping("/cars/{carId}")
	@ApiOperation(value = "Update Car data", notes = "Update Car data by Car ID", tags = {"Vehicle Management"})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Car data updated successfully"),
			@ApiResponse(code = 404, message = "Car ID not found"),
			@ApiResponse(code = 500, message = "Internal server error")
	})
	public Car putCars(@RequestBody Car car, @PathVariable Integer carId) {
		
		return this.carService.updateCar(car, carId);
	}
	
	@DeleteMapping("cars/{carId}")
	@ApiOperation(value = "Delete Car data", notes = "Delete Car data by Car ID", tags = {"Vehicle Management"})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Car data deleted successfully"),
			@ApiResponse(code = 404, message = "Car ID not found"),
			@ApiResponse(code = 500, message = "Internal server error")
	})
	public ResponseEntity<String> deleteCar(@PathVariable Integer carId){
		if(this.carService.deleteCarById(carId)) {
		return ResponseEntity.ok("Deleted");
		}else {
			return ResponseEntity.ok("Error");
		}
	}
}
