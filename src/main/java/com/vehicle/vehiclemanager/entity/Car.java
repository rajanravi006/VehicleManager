package com.vehicle.vehiclemanager.entity;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
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
public class Car {
	
	@Id
	private Integer carId;
	private String condition;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "detail_id", referencedColumnName = "detailId")
	private Details details;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "lcoation_id",referencedColumnName = "lcoationId")
	private Location location;
	
	
}
