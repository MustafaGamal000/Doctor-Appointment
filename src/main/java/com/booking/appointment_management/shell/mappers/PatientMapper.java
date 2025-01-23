package com.booking.appointment_management.shell.mappers;


import com.booking.Appointment_booking.shared.dto.PatientDTO;
import com.booking.appointment_management.core.domain.Patient;

public class PatientMapper {
    public static Patient toDomain(PatientDTO entity) {
        return new Patient(entity.getPatientId(), entity.getPatientName());
    }
}