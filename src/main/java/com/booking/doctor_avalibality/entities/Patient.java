package com.booking.doctor_avalibality.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Patients")
public class Patient {

    @Id
    @GeneratedValue
    private UUID patientId;

    @Column(nullable = false)
    private String patientName;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Appointment> appointments;

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

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}