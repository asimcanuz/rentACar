package org.asodev.rentacar.service;


import org.asodev.rentacar.dto.Vehicle.AddVehicleDto;
import org.asodev.rentacar.dto.Vehicle.VehicleDto;
import org.asodev.rentacar.model.Vehicle;
import org.asodev.rentacar.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class VehicleService {
    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public List<VehicleDto> getAllVehicles() {
        List<Vehicle> entities = vehicleRepository.findAll();
        return entities.stream().map(VehicleDto::fromEntity).toList();
    }

    public Optional<VehicleDto> getVehicleById(UUID id) {
        return vehicleRepository.findById(id).map(VehicleDto::fromEntity);
    }

    public VehicleDto addNewVehicle(AddVehicleDto addVehicleDto) {
        Vehicle entityToSave = AddVehicleDto.toEntity(addVehicleDto);
        // Perform any validation or business logic before saving
        Vehicle savedEntity = vehicleRepository.save(entityToSave);
        return VehicleDto.fromEntity(savedEntity);
    }

    public Optional<VehicleDto> updateVehicle(UUID id, VehicleDto updatedVehicleDto) {
        // Check if the vehicle with the given id exists
        return vehicleRepository.findById(id).map(existingEntity -> {
            Vehicle updatedEntity = VehicleDto.toEntity(updatedVehicleDto);
            return VehicleDto.fromEntity(vehicleRepository.save(updatedEntity));
        });
    }

    public void deleteVehicle(UUID id) {
        vehicleRepository.deleteById(id);
    }


}
