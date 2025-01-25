package com.booking.Appointment_booking.internal.infrastructue.repositories;

import com.booking.Appointment_booking.internal.domain.contract.AppointmentRepository;
import com.booking.Appointment_booking.internal.domain.models.Appointment;
import com.booking.Appointment_booking.internal.infrastructue.mappers.AppointmentMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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

    @Override
    public List<Appointment> findByDoctorId(UUID doctorId) {
        return repository.findByDoctorId(doctorId).stream()
                .map(AppointmentMapper::toDomain)
                .collect(Collectors.toList());
    }
}
