package com.booking.appointment_management.shell.dtos;

import java.util.UUID;

public class ManagementPatientDTO {
    private UUID patientId;
    private String patientName;

    public ManagementPatientDTO(UUID patientId, String patientName) {
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
