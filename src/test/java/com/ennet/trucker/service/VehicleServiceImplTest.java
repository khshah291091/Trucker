package com.ennet.trucker.service;

import com.ennet.trucker.Exception.ResourceNotFoundException;
import com.ennet.trucker.entity.Vehicle;
import com.ennet.trucker.repository.VehicleRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;


@RunWith(SpringRunner.class)
public class VehicleServiceImplTest {

    @TestConfiguration
    static class VehicleServiceImplTestConfig{
        @Bean
        public VehicleService getService(){
            return new VehicleServiceImpl();
        }
    }

    @Autowired
    private VehicleService service;

    @MockBean
    private VehicleRepository repository;

    private List<Vehicle> vehicles;

    @Before
    public void setup(){
        Vehicle vehicle = new Vehicle();
        vehicle.setVin("vin-1");
        vehicle.setMake("FORD");
        vehicle.setModel("FUSION");
        vehicle.setYear("2016");
        vehicle.setMaxFuelVolume(15);
        vehicle.setLastServiceDate("2017-05-25T17:31:25.268Z");

        vehicles = Collections.singletonList(vehicle);

        Mockito.when(repository.findAll())
                .thenReturn(vehicles);
        Mockito.when(repository.findByVin("vin-1"))
                .thenReturn(vehicle);
        Mockito.when(repository.save(vehicle))
                .thenReturn(vehicle);
    }

    @After
    public void cleanUp(){
    }


    /*@Test(expected = ResourceNotFoundException.class)
    public void findAllEmpty(){
        service.findAll();
    }*/

    @Test
    public void findAll() {
        List<Vehicle> result = service.findAll();
        Assert.assertEquals("Should Return all Employees",result,vehicles);
    }

    @Test
    public void findByVin() {
        Vehicle vehicle = service.findByVin(vehicles.get(0).getVin());
        Assert.assertEquals("Should return one employee", vehicles.get(0), vehicle);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void findByVinNotFound() {
        service.findByVin("anything");
    }

    @Test
    public void create() {
        Vehicle vehicle1 = new Vehicle();
        vehicle1.setVin("vin-2");
        vehicle1.setMake("FORD");
        vehicle1.setModel("FUSION");
        vehicle1.setYear("2016");
        vehicle1.setMaxFuelVolume(15);
        vehicle1.setLastServiceDate("2017-05-25T17:31:25.268Z");
        vehicles = Collections.singletonList(vehicle1);

        Mockito.when(service.create(vehicle1))
                .thenReturn(vehicle1);
    }

    @Test
    public void updateExisting() {
        Vehicle newVehicle = vehicles.get(0);
        newVehicle.setVin(newVehicle.getVin());
        newVehicle.setModel("X3");
        newVehicle.setMake("BMW");
        newVehicle.setYear("2018");
        Mockito.when(service.update(vehicles)).thenReturn(vehicles);
    }

    @Test
    public void updateForNewVehicle() {
        Vehicle vehicle1 = new Vehicle();
        vehicle1.setVin("vin-3");
        vehicle1.setMake("Audi");
        vehicle1.setModel("A6");
        vehicle1.setYear("2009");
        vehicle1.setMaxFuelVolume(13);
        vehicle1.setLastServiceDate("2017-05-25T17:31:25.268Z");
        vehicles = Collections.singletonList(vehicle1);
        Mockito.when(service.update(vehicles)).thenReturn(vehicles);
    }

    @Test
    public void delete() {
        Assert.assertEquals(service.deleteVehiclesByVin(vehicles.get(0).getVin()),true);

    }

    @Test(expected = ResourceNotFoundException.class)
    public void vinNotFoundDelete() {
        service.deleteVehiclesByVin("xyz");
    }

    @Test
    public void deleteAllTest(){
        service.deleteAll();
    }
}