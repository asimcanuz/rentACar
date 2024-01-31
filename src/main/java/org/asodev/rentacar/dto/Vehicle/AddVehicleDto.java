package org.asodev.rentacar.dto.Vehicle;

import org.asodev.rentacar.model.Vehicle;
import org.asodev.rentacar.model.VehicleStatus;

public record AddVehicleDto(
        String brand,
        String model,
        int year,
        String color,
        String plateNumber,
        Double dailyRate,
        VehicleStatus status
) {

    public static Vehicle toEntity(AddVehicleDto addVehicleDto) {
        return new Vehicle(addVehicleDto.brand, addVehicleDto.model, addVehicleDto.year,addVehicleDto.color, addVehicleDto.plateNumber, addVehicleDto.dailyRate,addVehicleDto.status);
    }

}
