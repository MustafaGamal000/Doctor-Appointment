package com.booking.Appointment_booking.shared.dto;

import java.util.UUID;
public class PatientDTO {
    private UUID patientId;
    private String patientName;

    public PatientDTO() {
    }

    public PatientDTO(UUID patientId, String patientName) {
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
}