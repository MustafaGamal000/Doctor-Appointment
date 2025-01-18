package com.booking.Appointment_booking.internal.infrastructue.repositories;

import com.booking.Appointment_booking.internal.infrastructue.entities.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaPatientRepository extends JpaRepository<PatientEntity, UUID> {
}
