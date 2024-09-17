package br.com.zup.parking.service;

import br.com.zup.parking.controllers.dtos.VehicleDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class ParkingService {
    private final List<VehicleDTO> vehicles = new ArrayList<>();

    public Optional<VehicleDTO> findVehicle(String plate) {
        return vehicles.stream().filter(VehicleDTO -> VehicleDTO.getPlate()
                .equalsIgnoreCase(plate)).findFirst();
    }

    public VehicleDTO addVehicle(String plate){
        Optional<VehicleDTO> vehicleDTOOptional = findVehicle(plate);

        if(vehicleDTOOptional.isPresent()){
            throw new RuntimeException("Vehicle already exists");
        }

        VehicleDTO vehicleDTO = new VehicleDTO();
        vehicleDTO.setPlate(plate);
        vehicleDTO.setArrival_time(LocalDateTime.now());
        vehicles.add(vehicleDTO);

        return vehicleDTO;
    }

    public List<VehicleDTO> getParking(){
        return vehicles;
    }

    public VehicleDTO exitParking(String plate) {
        Optional<VehicleDTO> vehicleDTOOptional = findVehicle(plate);

        if (vehicleDTOOptional.isEmpty()) {
            throw new RuntimeException("Vehicle not found");
        }

        VehicleDTO parkedVehicle = vehicleDTOOptional.get();
        parkedVehicle.setDeparture_time(LocalDateTime.now());
        parkedVehicle.setPrice(10);
        //vehicles.remove(parkedVehicle);

        return parkedVehicle;
    }

}
