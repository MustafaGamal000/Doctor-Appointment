package com.booking.doctor_avalibality.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "Appointments")
public class Appointment {

    @Id
    @GeneratedValue
    @Column(name = "AppointmentId")
    private UUID appointmentId;

    @ManyToOne
    @JoinColumn(name = "slot_id", referencedColumnName = "SlotId")
    @JsonBackReference
    private Slot slot;

    @ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "PatientId")
    @JsonManagedReference
    private Patient patient;

    private LocalDateTime reservedAt;

    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;

    public AppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }

    public UUID getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(UUID appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public LocalDateTime getReservedAt() {
        return reservedAt;
    }

    public void setReservedAt(LocalDateTime reservedAt) {
        this.reservedAt = reservedAt;
    }
}