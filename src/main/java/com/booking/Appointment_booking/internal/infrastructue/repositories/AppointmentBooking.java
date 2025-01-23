package com.booking.Appointment_booking.internal.infrastructue.repositories;

import com.booking.Appointment_booking.internal.infrastructue.mappers.AppointmentMapper;
import com.booking.Appointment_booking.internal.infrastructue.repositories.JpaAppointmentRepository;
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
}

