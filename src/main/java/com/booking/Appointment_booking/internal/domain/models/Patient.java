package com.booking.Appointment_booking.internal.domain.models;

import java.util.Objects;
import java.util.UUID;
public class Patient {
    private UUID patientId;
    private String patientName;

    public Patient() {
    }

    public Patient(UUID patientId, String patientName) {
        this.patientId = patientId;
        this.patientName = patientName;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Objects.equals(patientId, patient.patientId) && Objects.equals(patientName, patient.patientName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patientId, patientName);
    }
}