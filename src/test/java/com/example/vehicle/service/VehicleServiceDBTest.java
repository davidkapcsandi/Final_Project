package com.example.vehicle.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.example.vehicle.domain.Vehicle;
import com.example.vehicle.repo.VehicleRepo;



@SpringBootTest
@ActiveProfiles("test")
public class VehicleServiceDBTest {
	
	private Vehicle input;
	private Vehicle returned;
	
@Autowired
private VehicleServiceDB serv;

@MockBean
private VehicleRepo rep;


@BeforeEach
void setUp() {
	System.out.println("before");
	input = new Vehicle("Yellow", 4, "Car");
	returned = new Vehicle(2, "Black", 2, "Motorbike");
	}
@Test
void testCreate() {
	System.out.println("test 1");

	Mockito.when(this.rep.save(input)).thenReturn(returned);

	assertThat(this.serv.create(input)).isEqualTo(returned);

	Mockito.verify(this.rep, Mockito.times(1)).save(input);
}
@Test
void testRead() {
	System.out.println("test 2");
	// GIVEN
	List<Vehicle> readList = new ArrayList<>();
	readList.add(input);
	// WHEN
	Mockito.when(this.rep.findAll()).thenReturn(readList);
	// THEN
	assertThat(this.serv.read()).isEqualTo(readList);
	// VERIFY
	Mockito.verify(this.rep, Mockito.times(1)).findAll();
}
@Test
void testReadOne() {
	Long id = 1L;
	
	Optional<Vehicle> optAnim = Optional.of(returned);
	// WHEN a certain method is called, return ....
	Mockito.when(this.rep.findById(id)).thenReturn(optAnim);
	// THEN check what was returned is equal to what was expected
	assertThat(this.serv.readOne(id)).isEqualTo(returned);
	// VERIFY
	Mockito.verify(this.rep, Mockito.times(1)).findById(id);
}
@Test
void testUpdate() {

	long id = 1L;
	
	Vehicle toUpdate = new Vehicle(id, "Yacht", 0, "White");
	Vehicle tryUpdateVehicle = new Vehicle(id, "Car", 4 ,"Blue");


	Vehicle updated = new Vehicle(id, toUpdate.getType(), toUpdate.getNumberOfWheels(), toUpdate.getColor());

	Mockito.when(this.rep.findById(id)).thenReturn(Optional.of(tryUpdateVehicle));
	Mockito.when(this.rep.save(updated)).thenReturn(updated);

	assertThat(this.serv.update(id, toUpdate)).isEqualTo(updated);

	Mockito.verify(this.rep, Mockito.times(1)).findById(id);
	Mockito.verify(this.rep, Mockito.times(1)).save(new Vehicle(id, "Yacht", 0, "White"));
}
@Test
void testDelete() {
	// GIVEN
	Long id = 1L;

	Optional<Vehicle> optChoco = Optional.of(returned);

	Mockito.when(this.rep.findById(id)).thenReturn(optChoco);

	assertThat(this.serv.delete(id)).isEqualTo(returned);

	Mockito.verify(this.rep, Mockito.times(1)).deleteById(id);
	Mockito.verify(this.rep, Mockito.times(1)).findById(id);
}
@Test
void testRemove() {

	Long id = 1L;

	Mockito.when(this.rep.existsById(id)).thenReturn(false);

	assertThat(this.serv.remove(id)).isTrue();

	Mockito.verify(this.rep, Mockito.times(1)).deleteById(id);
	Mockito.verify(this.rep, Mockito.times(1)).existsById(id);
}
@AfterEach
void clear() {

	}
}