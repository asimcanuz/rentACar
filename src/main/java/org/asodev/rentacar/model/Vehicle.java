package org.asodev.rentacar.model;


import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "Vehicles")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "VehicleID",columnDefinition = "BINARY(16)")
    private UUID vehicleID;

    @Column(name = "Brand")
    private String brand;

    @Column(name = "Model")
    private String model;

    @Column(name = "`year`")
    private int year;

    @Column(name = "Color")
    private String color;

    @Column(name = "PlateNumber", unique = true)
    private String plateNumber;

    @Column(name = "DailyRate")
    private Double dailyRate;

    @Enumerated(EnumType.STRING)
    @Column(name = "Status",nullable = false,columnDefinition = "VARCHAR(255) DEFAULT 'AVAILABLE'")
    private VehicleStatus status=VehicleStatus.AVAILABLE;

    public Vehicle() {
    }

    public Vehicle(UUID vehicleID, String brand, String model, int year, String color, String plateNumber, Double dailyRate, VehicleStatus status) {
        this.vehicleID = vehicleID;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.plateNumber = plateNumber;
        this.dailyRate = dailyRate;
        this.status = status;
    }

    public Vehicle(String brand, String model, int year, String color, String plateNumber, Double dailyRate, VehicleStatus status) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.plateNumber = plateNumber;
        this.dailyRate = dailyRate;
        this.status = status;
    }

    public UUID getVehicleID() {
        return vehicleID;
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public Double getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(Double dailyRate) {
        this.dailyRate = dailyRate;
    }

    public VehicleStatus getStatus() {
        return status;
    }

    public void setStatus(VehicleStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return year == vehicle.year && Objects.equals(vehicleID, vehicle.vehicleID) && Objects.equals(brand, vehicle.brand) && Objects.equals(model, vehicle.model) && Objects.equals(color, vehicle.color) && Objects.equals(plateNumber, vehicle.plateNumber) && Objects.equals(dailyRate, vehicle.dailyRate) && status == vehicle.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicleID, brand, model, year, color, plateNumber, dailyRate, status);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleID=" + vehicleID +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", color='" + color + '\'' +
                ", plateNumber='" + plateNumber + '\'' +
                ", dailyRate=" + dailyRate +
                ", status=" + status +
                '}';
    }
}

