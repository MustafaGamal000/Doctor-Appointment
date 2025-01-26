package com.booking.Appointment_booking.internal.infrastructue.repositories;

import com.booking.Appointment_booking.internal.infrastructue.entities.AppointmentEntity;
import com.booking.Appointment_booking.internal.shared.AppointmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface JpaAppointmentRepository extends JpaRepository<AppointmentEntity, UUID> {
    List<AppointmentEntity> findByDoctorId(UUID doctorId);
    Optional<AppointmentEntity> findByAppointmentId(UUID appointmentId);
    @Modifying
    @Transactional
    @Query("UPDATE AppointmentEntity a SET a.status = :status WHERE a.appointmentId = :appointmentId")
    int updateStatusById(@Param("appointmentId") UUID appointmentId, @Param("status") AppointmentStatus status);

}
