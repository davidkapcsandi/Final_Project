package com.example.vehicle.rest;

import java.util.List;

import javax.websocket.server.PathParam;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.vehicle.domain.Vehicle;
import com.example.vehicle.service.VehicleServiceDB;

@RestController
public class VehicleController {

	private VehicleServiceDB service;
	
	public VehicleController(VehicleServiceDB service) {
		super();
		this.service = service;
	}
		@PostMapping("/create")
		public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle x) {
			return new ResponseEntity<Vehicle>(this.service.create(x), HttpStatus.CREATED);
	}
	
		@GetMapping("readAll")
		public List<Vehicle> readAnimal() {
			return this.service.read();
		}

		@GetMapping("/readById/{id}")
		public Vehicle getById(@PathVariable Long id) {
			return this.service.readOne(id);
		}

		@PutMapping("/update/{id}")
		public Vehicle update(@PathVariable Long id, @RequestBody Vehicle updated) {
			return this.service.update(id, updated);
		}

		@DeleteMapping("/delete")
		public Vehicle delete(@PathParam("id") Long id) {
			return this.service.delete(id);
		}
		

	
}
