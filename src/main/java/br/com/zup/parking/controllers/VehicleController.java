package br.com.zup.parking.controllers;

import br.com.zup.parking.controllers.dtos.*;
import br.com.zup.parking.service.ParkingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/parking")
public class VehicleController {

    @Autowired //injetara os atributos
    private ParkingService parkingService;

    @GetMapping
    public ResponseEntity<?> showParking(){
        return ResponseEntity.ok(parkingService.getParking());
    }

    @PostMapping
    public ResponseEntity<?> addVehicle(@RequestBody @Valid PlateDTO plate){
        try{
            VehicleDTO vehicleDTO = parkingService.addVehicle(plate.getPlate());
            return ResponseEntity.status(201).body(vehicleDTO);
        }catch (RuntimeException e){
            return ResponseEntity.status(400).body(Map.of("mensagem", e.getMessage()));
        }
    }

    @PatchMapping("/{plate}")
    public ResponseEntity<?> updateVehicle(@RequestBody @Valid PlateDTO plate){
        try {
            VehicleDTO vehicleDTO = parkingService.exitParking(plate.getPlate());
            return ResponseEntity.status(201).body(vehicleDTO);
        } catch (RuntimeException e){
            return ResponseEntity.status(400).body(Map.of("mensagem", e.getMessage()));
        }
    }
}
