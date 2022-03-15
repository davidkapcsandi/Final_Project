package com.example.vehicle.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.vehicle.domain.Vehicle;

@Repository
public interface VehiclesRepo extends JpaRepository<Vehicle, Long>{
	


}
