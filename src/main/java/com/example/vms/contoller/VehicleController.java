package com.example.vms.contoller;


import com.example.vms.model.Vehicle;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    private List<Vehicle> vehicleList = new ArrayList<>();
    int counter = 0;

    /**
     * add new vehicle
     *
     * @param vehicle
     * @return vehicle
     */
    @PostMapping("/save")
    public Vehicle addNewVehicle(@RequestBody Vehicle vehicle) {
        Vehicle newVehicle = new Vehicle(autoIDGenerator(), vehicle.getMake(), vehicle.getModel(), vehicle.getYear(), vehicle.getTransmissionType());
        vehicleList.add(newVehicle);
        return newVehicle;
    }

    /**
     * get all vehicles
     *
     * @return
     */
    @GetMapping("/all")
    public List<Vehicle> retrieveAllVehicle() {
        return vehicleList;
    }


    /**
     * retrieve vehicle by id
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Vehicle retrieveVehicleById(@PathVariable long id) {
        for (Vehicle vehicle : vehicleList) {
            if (id == vehicle.getId()) {
                return vehicle;
            }
        }
        throw new RuntimeException("Vehicle with id: " + id + " not found");
    }


    /**
     * remove vehicle by id
     *
     * @param id
     */
    @DeleteMapping("/{id}")
    public void removeVehicleById(@PathVariable long id) {
        if (!vehicleList.isEmpty()) {
            for (Vehicle vehicle : vehicleList) {
                if (vehicle.getId() == id) {
                    vehicleList.remove(vehicle);
                    break;
                }

            }
        } else {
            throw new RuntimeException("Vehicle with id: " + id + " not found");
        }
    }

    /**
     * update vehicle info by id number
     *
     * @param vehicle
     * @param id
     * @return
     */

    @PutMapping("update/{id}")
    public Vehicle updateVehicle(@RequestBody Vehicle vehicle, @PathVariable long id) {

        for (Vehicle ve : vehicleList) {
            if (ve.getId() == id) {
                ve.setMake(vehicle.getMake());
                ve.setModel(vehicle.getModel());
                ve.setYear(vehicle.getYear());
                ve.setTransmissionType(vehicle.getTransmissionType());
                return ve;
            }
        }
        throw new RuntimeException("Vehicle with id: " + id + " not found");
    }

    private int autoIDGenerator() {
        return counter += 1;
    }


}
