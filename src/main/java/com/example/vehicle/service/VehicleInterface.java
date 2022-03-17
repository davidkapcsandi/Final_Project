package com.example.vehicle.service;

import java.util.List;

import com.example.vehicle.domain.Vehicle;

public interface VehicleInterface<T> {
	
	Vehicle create(Vehicle a);
	
	List<Vehicle> read();
	
	Vehicle update(T id, Vehicle b);
	
	Vehicle delete(T id);

}
