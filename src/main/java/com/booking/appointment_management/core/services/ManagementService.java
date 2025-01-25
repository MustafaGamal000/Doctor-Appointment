package com.booking.appointment_management.core.services;

import com.booking.appointment_management.core.domain.Appointment;
import com.booking.appointment_management.core.port.IAppointmentRepository;
import com.booking.Appointment_booking.shared.AppointmentStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ManagementService {
    private final IAppointmentRepository appointmentRepository;

    public ManagementService(IAppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public List<Appointment> getUpcomingAppointment(UUID doctorId) {
        return appointmentRepository.findAppointmentByDoctorId(doctorId)
                .stream()
                .filter(appointment -> appointment.getSlot().getTime().isAfter(LocalDateTime.now()))
                .toList();
    }

    public String changeCurrentStatus(UUID appointmentId, AppointmentStatus status){
        int updatedRows = appointmentRepository.updateStatusById(appointmentId, status);

        if (updatedRows == 0) {
            throw new IllegalArgumentException("Appointment not found");
        }

        return "Appointment status updated successfully to " + status;
    }
}
