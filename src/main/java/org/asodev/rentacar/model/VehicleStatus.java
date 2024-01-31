package org.asodev.rentacar.model;

public enum VehicleStatus {
    AVAILABLE("Available"),
    RENTED("Rented"),
    MAINTENANCE("Maintenance");

    private final String value;

    VehicleStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
