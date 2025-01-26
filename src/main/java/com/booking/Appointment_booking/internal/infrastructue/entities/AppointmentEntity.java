package com.booking.Appointment_booking.internal.infrastructue.entities;

import com.booking.Appointment_booking.internal.shared.AppointmentStatus;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "Appointments")
public class AppointmentEntity {

    @Id
    @GeneratedValue
    @Column(name = "AppointmentId")
    private UUID appointmentId;

    @Column(name = "slot_id", nullable = false)
    private UUID slotId;

    @Column(name = "doctor_id", nullable = false)
    private UUID doctorId;

    @ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "PatientId")
    @JsonManagedReference
    private PatientEntity patient;

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

    public PatientEntity getPatient() {
        return patient;
    }

    public void setPatient(PatientEntity patient) {
        this.patient = patient;
    }

    public LocalDateTime getReservedAt() {
        return reservedAt;
    }

    public void setReservedAt(LocalDateTime reservedAt) {
        this.reservedAt = reservedAt;
    }

    public UUID getSlotId() {
        return slotId;
    }

    public void setSlotId(UUID slotId) {
        this.slotId = slotId;
    }

    public UUID getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(UUID doctorId) {
        this.doctorId = doctorId;
    }
}