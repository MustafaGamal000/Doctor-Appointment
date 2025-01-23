package com.booking.appointment_management.shell.web;

import com.booking.appointment_management.core.services.GetUpcomingAppointmentUseCase;
import com.booking.appointment_management.core.dtos.UpcomingAppointmentDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/appointment-management")
public class AppointmentManagementController {

    private final GetUpcomingAppointmentUseCase getUpcomingAppointmentUseCase;

    public AppointmentManagementController(GetUpcomingAppointmentUseCase getUpcomingAppointmentUseCase) {
        this.getUpcomingAppointmentUseCase = getUpcomingAppointmentUseCase;
    }

    @GetMapping("/upcoming-appointments/{doctorId}")
    public List<UpcomingAppointmentDTO> getUpcomingAppointments(@PathVariable UUID doctorId) {
        return getUpcomingAppointmentUseCase.execute(doctorId);
    }
}