package com.example.vehicle.domain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String type;
	private int numberOfWheels;
	private String color;
	
	public Vehicle() {
		super();
	}
	
	public Vehicle(long id, String type, int numberOfWheels, String color) {
		super();
		this.id = id;
		this.type = type;
		this.numberOfWheels = numberOfWheels;
		this.color = color;
	}
	public Vehicle(String type, int numberOfWheels, String color) {
		super();
		this.type = type;
		this.numberOfWheels = numberOfWheels;
		this.color = color;
	}
		
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getNumberOfWheels() {
		return numberOfWheels;
	}
	public void setNumberOfWheels(int numberOfWheels) {
		this.numberOfWheels = numberOfWheels;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		return Objects.equals(color, other.color) 
				&& numberOfWheels == other.numberOfWheels && Objects.equals(type, other.type)&& Objects.equals(id, other.id);
	}

}

