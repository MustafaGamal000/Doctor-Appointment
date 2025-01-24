package com.booking.Appointment_booking.internal.infrastructue.repositories;

import com.booking.Appointment_booking.internal.infrastructue.mappers.AppointmentMapper;
import com.booking.Appointment_booking.internal.shared.AppointmentStatus;
import com.booking.Appointment_booking.shared.contract.IAppointmentBooking;
import com.booking.Appointment_booking.shared.dto.AppointmentDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AppointmentBooking implements IAppointmentBooking {
    private final JpaAppointmentRepository repository;

    public AppointmentBooking(JpaAppointmentRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<AppointmentDTO> findByDoctorId(UUID doctorId) {
        return repository.findByDoctorId(doctorId).stream()
                .map(AppointmentMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AppointmentDTO findByAppointmentId(UUID appointmentId) {
        return repository.findByAppointmentId(appointmentId)
                .map(AppointmentMapper::toDTO)
                .orElseThrow(() -> new IllegalArgumentException("Appointment with id: " + appointmentId + " not found..!"));

    }

    @Override
    public int updateStatusById(UUID appointmentId, AppointmentStatus status) {
        return repository.updateStatusById(appointmentId, status);
    }
}

