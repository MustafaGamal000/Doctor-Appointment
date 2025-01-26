package com.booking.appointment_management.shell.adapters;

import com.booking.Appointment_booking.internal.shared.AppointmentStatus;
import com.booking.appointment_management.core.domain.Appointment;
import com.booking.appointment_management.core.port.IAppointmentRepository;
import com.booking.Appointment_booking.shared.contract.IAppointmentBooking;
import com.booking.appointment_management.shell.mappers.AppointmentMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class ManagementAppointmentRepository implements IAppointmentRepository {
    private final IAppointmentBooking appointmentRepository;

    public ManagementAppointmentRepository(IAppointmentBooking appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }


    @Override
    public List<Appointment> findAppointmentByDoctorId(UUID doctorId) {
        return appointmentRepository.findByDoctorId(doctorId).stream()
                .map(AppointmentMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public int updateStatusById(UUID appointmentId, AppointmentStatus status) {
        return appointmentRepository.updateStatusById(appointmentId, status);
    }
}
