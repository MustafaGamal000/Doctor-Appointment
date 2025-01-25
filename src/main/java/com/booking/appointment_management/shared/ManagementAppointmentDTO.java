package com.booking.appointment_management.shared;

import java.time.LocalDateTime;
import java.util.UUID;

public class ManagementAppointmentDTO {
    private UUID appointmentId;
    private LocalDateTime reservedAt;
    private String status;
    private ManagementPatientDTO patient;

    public ManagementAppointmentDTO(UUID appointmentId, LocalDateTime reservedAt, String status, ManagementPatientDTO patient) {
        this.appointmentId = appointmentId;
        this.reservedAt = reservedAt;
        this.status = status;
        this.patient = patient;
    }

    public UUID getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(UUID appointmentId) {
        this.appointmentId = appointmentId;
    }

    public LocalDateTime getReservedAt() {
        return reservedAt;
    }

    public void setReservedAt(LocalDateTime reservedAt) {
        this.reservedAt = reservedAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ManagementPatientDTO getPatient() {
        return patient;
    }

    public void setPatient(ManagementPatientDTO patient) {
        this.patient = patient;
    }
}
