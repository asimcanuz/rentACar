package org.asodev.rentacar.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "MaintenanceHistory")
public class MaintenanceHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "MaintenanceID", columnDefinition = "BINARY(16)")
    private Long maintenanceID;

    @ManyToOne
    @JoinColumn(name = "VehicleID", nullable = false)
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "RentalWorkerID", nullable = false)
    private RentalWorker rentalWorker;

    @Column(name = "MaintenanceDate")
    private LocalDateTime maintenanceDate;

    @Column(name = "Description")
    private String description;

    @Column(name = "MaintenanceCost")
    private Double maintenanceCost;

    public MaintenanceHistory(RentalWorker rentalWorker) {
        this.rentalWorker = rentalWorker;
    }

    public MaintenanceHistory(Long maintenanceID, Vehicle vehicle, RentalWorker rentalWorker, LocalDateTime maintenanceDate, String description, Double maintenanceCost) {
        this.maintenanceID = maintenanceID;
        this.vehicle = vehicle;
        this.rentalWorker = rentalWorker;
        this.maintenanceDate = maintenanceDate;
        this.description = description;
        this.maintenanceCost = maintenanceCost;
    }

    public Long getMaintenanceID() {
        return maintenanceID;
    }

    public void setMaintenanceID(Long maintenanceID) {
        this.maintenanceID = maintenanceID;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public RentalWorker getRentalWorker() {
        return rentalWorker;
    }

    public void setRentalWorker(RentalWorker rentalWorker) {
        this.rentalWorker = rentalWorker;
    }

    public LocalDateTime getMaintenanceDate() {
        return maintenanceDate;
    }

    public void setMaintenanceDate(LocalDateTime maintenanceDate) {
        this.maintenanceDate = maintenanceDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getMaintenanceCost() {
        return maintenanceCost;
    }

    public void setMaintenanceCost(Double maintenanceCost) {
        this.maintenanceCost = maintenanceCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MaintenanceHistory that = (MaintenanceHistory) o;
        return Objects.equals(maintenanceID, that.maintenanceID) && Objects.equals(vehicle, that.vehicle) && Objects.equals(maintenanceDate, that.maintenanceDate) && Objects.equals(description, that.description) && Objects.equals(maintenanceCost, that.maintenanceCost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maintenanceID, vehicle, maintenanceDate, description, maintenanceCost);
    }

    @Override
    public String toString() {
        return "MaintenanceHistory{" + "maintenanceID=" + maintenanceID + ", vehicle=" + vehicle + ", maintenanceDate=" + maintenanceDate + ", description='" + description + '\'' + ", maintenanceCost=" + maintenanceCost + '}';
    }

}
