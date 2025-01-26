package com.booking.appointment_management.shell.web;

import com.booking.shared.AppointmentStatus;
import com.booking.appointment_management.core.services.ManagementService;
import com.booking.appointment_management.shell.dtos.ManagementDoctorDTO;
import com.booking.appointment_management.shell.mappers.ManagementMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/appointment-management")
public class AppointmentManagementController {

    private final ManagementService managementService;

    public AppointmentManagementController(ManagementService managementService) {
        this.managementService = managementService;
    }

    @GetMapping("/upcoming-appointments/{doctorId}")
    public List<ManagementDoctorDTO> getUpcomingAppointments(@PathVariable UUID doctorId) {
        var doctorAppointments = managementService.getUpcomingAppointment(doctorId);
        return ManagementMapper.toManagementDoctorDTOs(doctorAppointments);
    }

    @PutMapping("/appointments/{appointmentId}/status")
    public ResponseEntity<String> updateAppointmentStatus(
            @PathVariable UUID appointmentId,
            @RequestParam AppointmentStatus newStatus) {
        String message = managementService.changeCurrentStatus(appointmentId, newStatus);
        return ResponseEntity.ok(message);

    }
}