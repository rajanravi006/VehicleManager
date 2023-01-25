package com.vehicle.vehiclemanager.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Details {
	//@OneToOne(cascade = CascadeType.ALL)
	//@JoinColumn(name = "asset_Id", referencedColumnName = "assetId")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer detailId;
	private String body;
	private String model;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "code", referencedColumnName = "code")
	private Manufacturer manufacturer;
	private Integer numberOfDoors;
	private String fuelType;
	private String engine;
	private Double mileage;
	private Integer modelYear;
	private Integer productionYear;
	private String externalColor;
	
}
