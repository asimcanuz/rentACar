package org.asodev.rentacar.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "Rentals")
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "RentalID",columnDefinition = "BINARY(16)")
    private UUID rentalID;

    @ManyToOne
    @JoinColumn(name = "CustomerID")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "VehicleID")
    private Vehicle vehicle;

    @Column(name = "RentalDate")
    private LocalDateTime rentalDate;

    @Column(name = "ReturnDate")
    private LocalDateTime returnDate;

    @Column(name = "TotalAmount")
    private Double totalAmount;

    public Rental() {
    }

    public Rental(UUID rentalID, Customer customer, Vehicle vehicle, LocalDateTime rentalDate, LocalDateTime returnDate, Double totalAmount) {
        this.rentalID = rentalID;
        this.customer = customer;
        this.vehicle = vehicle;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.totalAmount = totalAmount;
    }

    public UUID getRentalID() {
        return rentalID;
    }

    public void setRentalID(UUID rentalID) {
        this.rentalID = rentalID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public LocalDateTime getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(LocalDateTime rentalDate) {
        this.rentalDate = rentalDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rental rental = (Rental) o;
        return Objects.equals(rentalID, rental.rentalID) && Objects.equals(customer, rental.customer) && Objects.equals(vehicle, rental.vehicle) && Objects.equals(rentalDate, rental.rentalDate) && Objects.equals(returnDate, rental.returnDate) && Objects.equals(totalAmount, rental.totalAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rentalID, customer, vehicle, rentalDate, returnDate, totalAmount);
    }

    @Override
    public String toString() {
        return "Rental{" +
                "rentalID=" + rentalID +
                ", customer=" + customer +
                ", vehicle=" + vehicle +
                ", rentalDate=" + rentalDate +
                ", returnDate=" + returnDate +
                ", totalAmount=" + totalAmount +
                '}';
    }
}