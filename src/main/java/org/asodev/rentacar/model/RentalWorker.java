package org.asodev.rentacar.model;

import jakarta.persistence.*;

import java.util.UUID;

// * TODO : Çalışan tablosu fieldlarını belirle
@Entity
@Table(name = "RentalWorkers")
public class RentalWorker {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "RentalWorkerID",columnDefinition = "BINARY(16)")
    private UUID rentalWorkerID;

}
