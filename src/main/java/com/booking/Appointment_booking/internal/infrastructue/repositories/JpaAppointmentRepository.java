package com.booking.Appointment_booking.internal.infrastructue.repositories;

import com.booking.Appointment_booking.internal.infrastructue.entities.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public interface JpaAppointmentRepository extends JpaRepository<AppointmentEntity, UUID> {
    List<AppointmentEntity> findByDoctorId(UUID doctorId);
}
