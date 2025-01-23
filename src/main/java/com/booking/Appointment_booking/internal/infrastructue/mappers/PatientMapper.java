package com.booking.Appointment_booking.internal.infrastructue.mappers;

import com.booking.Appointment_booking.internal.domain.models.Patient;
import com.booking.Appointment_booking.internal.infrastructue.entities.PatientEntity;
import com.booking.Appointment_booking.shared.dto.PatientDTO;

public class PatientMapper {
    public static Patient toDomain(PatientEntity entity) {
        return new Patient(entity.getPatientId(), entity.getPatientName());
    }

    public static PatientEntity toEntity(Patient patient) {
        PatientEntity entity = new PatientEntity();
        entity.setPatientId(patient.getPatientId());
        entity.setPatientName(patient.getPatientName());
        return entity;
    }

    public static PatientDTO toDTO(PatientEntity entity) {
        return new PatientDTO(entity.getPatientId(), entity.getPatientName());
    }
}