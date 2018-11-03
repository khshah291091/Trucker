package com.ennet.trucker.service;

import com.ennet.trucker.Exception.ResourceNotFoundException;
import com.ennet.trucker.entity.Vehicles;
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

    private List<Vehicles> vehicles;

    @Before
    public void setup(){
        Vehicles vehicle = new Vehicles();
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
    //TODO: implementation pending!
/*    @Test(expected = ResourceNotFoundException.class)
    public void findAllEmpty(){
        service.findAll();
    }*/

    @Test
    public void findAll() {
        List<Vehicles> result = service.findAll();
        Assert.assertEquals("Should Return all Employees",result,vehicles);
    }

    @Test
    public void findByVin() {
        Vehicles vehicle = service.findByVin(vehicles.get(0).getVin());
        Assert.assertEquals("Should return one employee", vehicles.get(0), vehicle);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void findByVinNotFound() {
        service.findByVin("anything");
    }

    @Test
    public void create() {
        Vehicles vehicles1 = new Vehicles();
        vehicles1.setVin("vin-2");
        vehicles1.setMake("FORD");
        vehicles1.setModel("FUSION");
        vehicles1.setYear("2016");
        vehicles1.setMaxFuelVolume(15);
        vehicles1.setLastServiceDate("2017-05-25T17:31:25.268Z");
        vehicles = Collections.singletonList(vehicles1);

        Mockito.when(service.create(vehicles1))
                .thenReturn(vehicles1);
    }

    @Test
    public void updateExisting() {
        Vehicles newVehicle = vehicles.get(0);
        newVehicle.setVin(newVehicle.getVin());
        newVehicle.setModel("X3");
        newVehicle.setMake("BMW");
        newVehicle.setYear("2018");
        Mockito.when(service.update(vehicles)).thenReturn(vehicles);
    }

    @Test
    public void updateForNewVehicle() {
        Vehicles vehicles1 = new Vehicles();
        vehicles1.setVin("vin-3");
        vehicles1.setMake("Audi");
        vehicles1.setModel("A6");
        vehicles1.setYear("2009");
        vehicles1.setMaxFuelVolume(13);
        vehicles1.setLastServiceDate("2017-05-25T17:31:25.268Z");
        vehicles = Collections.singletonList(vehicles1);
        Mockito.when(service.update(vehicles)).thenReturn(vehicles);
    }

    @Test
    public void delete() {

        /*Mockito.doNothing().doThrow(new ResourceNotFoundException("No Vehicle found by the given VIN")).when(repository).delete(vehicles.get(0));
        Vehicles v = vehicles.get(0);
        Mockito.when(repository.findByVin(vehicles.get(0).getVin())).thenReturn(v);
        repository.delete(v);
        Mockito.verify(repository).delete(v);*/
        //TODO: Assertion pending
        service.delete(vehicles.get(0).getVin());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void vinNotFoundDelete() {
        service.delete("xyz");
    }
}