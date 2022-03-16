package com.example.vehicle.service;

import java.util.ArrayList;
import java.util.List;

import com.example.vehicle.domain.Vehicle;

public class VehicleServiceList implements VehicleInterface<Integer> {
	private List<Vehicle> vehicle = new ArrayList<>();

	@Override
	public Vehicle create(Vehicle a) {
		// TODO Auto-generated method stub
		a.setId((long) this.vehicle.indexOf(a));
		this.vehicle.add(a);
		Vehicle created = this.vehicle.get(this.vehicle.size() - 1);
		return created;
	}

	@Override
	public List<Vehicle> read() {
		// TODO Auto-generated method stub
		return this.vehicle;
	}

	@Override
	public Vehicle update(Integer id, Vehicle b) {
		// TODO Auto-generated method stub
		this.vehicle.set(id, b);
		return this.vehicle.get(id);
	}

	@Override
	public Vehicle delete(Integer id) {
		// TODO Auto-generated method stub
		return this.vehicle.remove((int)id);
	}

	
}
