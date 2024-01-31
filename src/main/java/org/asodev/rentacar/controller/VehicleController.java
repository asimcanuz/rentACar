package org.asodev.rentacar.controller;

import org.asodev.rentacar.dto.Vehicle.AddVehicleDto;
import org.asodev.rentacar.dto.Vehicle.VehicleDto;
import org.asodev.rentacar.service.VehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public List<VehicleDto> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleDto> getVehicleById(@PathVariable UUID id) {
        Optional<VehicleDto> vehicleDto = vehicleService.getVehicleById(id);
        return vehicleDto.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<VehicleDto> createVehicle(@RequestBody AddVehicleDto vehicleDto) {
        VehicleDto savedVehicleDto = vehicleService.addNewVehicle(vehicleDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedVehicleDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VehicleDto> updateVehicle(
            @PathVariable UUID id,
            @RequestBody VehicleDto updatedVehicleDto
    ) {
        Optional<VehicleDto> result = vehicleService.updateVehicle(id, updatedVehicleDto);
        return result.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable UUID id) {
        vehicleService.deleteVehicle(id);
        return ResponseEntity.noContent().build();
    }
}
