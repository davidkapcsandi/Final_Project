package com.example.vehicle.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.vehicle.domain.Vehicle;
import com.example.vehicle.repo.VehicleRepo;


@Service
public class VehicleServiceDB implements VehicleInterface<Long> {
	
	private VehicleRepo repo;
	
	public VehicleServiceDB(VehicleRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public Vehicle create(Vehicle a) {
		return this.repo.save(a);
	}

	@Override
	public List<Vehicle> read() {
		return this.repo.findAll();
	}
		
	
	public Vehicle readOne(Long id) {
		// TODO Auto-generated method stub
		Optional<Vehicle> optRead = this.repo.findById(id);
		return optRead.orElse(null);
	}

	@Override
	public Vehicle update(Long id, Vehicle b) {
		// TODO Auto-generated method stub
		Optional<Vehicle> optAni =  this.repo.findById(id);
		Vehicle found = optAni.get();
		found.setType(b.getType());
		found.setNumberOfWheels(b.getNumberOfWheels());
		found.setColor(b.getColor());
		return this.repo.save(found);
	}

	@Override
	public Vehicle delete(Long id) {
		Optional<Vehicle> toDelete = this.repo.findById(id);
		this.repo.deleteById(id);
		return toDelete.orElse(null);
	}

	public boolean remove(Long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}
	
	
}


