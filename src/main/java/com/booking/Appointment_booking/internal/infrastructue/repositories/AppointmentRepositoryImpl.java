package com.booking.Appointment_booking.internal.infrastructue.repositories;

import com.booking.Appointment_booking.internal.domain.contract.AppointmentRepository;
import com.booking.Appointment_booking.internal.domain.models.Appointment;
import com.booking.Appointment_booking.internal.infrastructue.mappers.AppointmentMapper;
import org.springframework.stereotype.Repository;

@Repository
public class AppointmentRepositoryImpl implements AppointmentRepository {
    private final JpaAppointmentRepository repository;

    public AppointmentRepositoryImpl(JpaAppointmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Appointment appointment) {
        repository.save(AppointmentMapper.toEntity(appointment));
    }
}
