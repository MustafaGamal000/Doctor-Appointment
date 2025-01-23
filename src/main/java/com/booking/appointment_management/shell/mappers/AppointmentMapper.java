package com.booking.appointment_management.shell.mappers;

import com.booking.Appointment_booking.shared.dto.AppointmentDTO;
import com.booking.appointment_management.core.domain.Appointment;

public class AppointmentMapper {
    public static Appointment toDomain(AppointmentDTO dto) {
        Appointment appointment = new Appointment();
        appointment.setAppointmentId(dto.getAppointmentId());
        appointment.setReservedAt(dto.getReservedAt());
        appointment.setStatus(dto.getStatus());
        appointment.setSlotId(dto.getSlotId());
        appointment.setDoctorId(dto.getDoctorId());

        if (dto.getPatient() != null) {
            appointment.setPatient(PatientMapper.toDomain(dto.getPatient()));
        }
        return appointment;
    }

}