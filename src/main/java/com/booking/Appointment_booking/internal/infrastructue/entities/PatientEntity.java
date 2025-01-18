package com.booking.Appointment_booking.internal.infrastructue.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Patients")
public class PatientEntity {

    @Id
    private UUID patientId;

    @Column(nullable = false)
    private String patientName;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<AppointmentEntity> appointments;

    public UUID getPatientId() {
        return patientId;
    }

    public void setPatientId(UUID patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public List<AppointmentEntity> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<AppointmentEntity> appointments) {
        this.appointments = appointments;
    }
}