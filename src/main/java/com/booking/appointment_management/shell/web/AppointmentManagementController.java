package com.booking.appointment_management.shell.web;

import com.booking.appointment_management.core.services.ManagementService;
import com.booking.appointment_management.shared.ManagementDoctorDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/appointment-management")
public class AppointmentManagementController {

    private final ManagementService getUpcomingAppointmentUseCase;

    public AppointmentManagementController(ManagementService getUpcomingAppointmentUseCase) {
        this.getUpcomingAppointmentUseCase = getUpcomingAppointmentUseCase;
    }

    @GetMapping("/upcoming-appointments/{doctorId}")
    public List<ManagementDoctorDTO> getUpcomingAppointments(@PathVariable UUID doctorId) {
        return getUpcomingAppointmentUseCase.getUpcomingAppointment(doctorId);
    }
}