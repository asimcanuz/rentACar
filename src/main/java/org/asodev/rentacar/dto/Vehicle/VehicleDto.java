package org.asodev.rentacar.dto.Vehicle;

import org.asodev.rentacar.model.Vehicle;
import org.asodev.rentacar.model.VehicleStatus;

import java.util.UUID;

public record VehicleDto(
        UUID vehicleID,
        String brand,
        String model,
        int year,
        String color,
        String plateNumber,
        Double dailyRate,
        VehicleStatus status
){
    public static VehicleDto fromEntity(Vehicle vehicle){
        return new VehicleDto(
                vehicle.getVehicleID(),
                vehicle.getBrand(),
                vehicle.getModel(),
                vehicle.getYear(),
                vehicle.getColor(),
                vehicle.getPlateNumber(),
                vehicle.getDailyRate(),
                vehicle.getStatus());
    }
    public static Vehicle toEntity(VehicleDto dto) {
        Vehicle entity = new Vehicle();
        entity.setBrand(dto.brand());
        entity.setModel(dto.model());
        entity.setYear(dto.year());
        entity.setColor(dto.color());
        entity.setPlateNumber(dto.plateNumber());
        entity.setDailyRate(dto.dailyRate());
        entity.setStatus(dto.status());
        return entity;
    }
}
