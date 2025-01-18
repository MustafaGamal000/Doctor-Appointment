package com.booking.Appointment_booking.internal.domain.contract;

import com.booking.Appointment_booking.internal.domain.models.Patient;

import java.util.Optional;
import java.util.UUID;

public interface PatientRepository {
    Optional<Patient> findById(UUID patientId);
    void save(Patient patient);
}
