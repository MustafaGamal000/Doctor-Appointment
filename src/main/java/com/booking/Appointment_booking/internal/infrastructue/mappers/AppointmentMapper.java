package com.booking.Appointment_booking.internal.infrastructue.mappers;

import com.booking.Appointment_booking.internal.domain.models.Appointment;
import com.booking.Appointment_booking.internal.infrastructue.entities.AppointmentEntity;
import com.booking.Appointment_booking.shared.dto.AppointmentDTO;

public class AppointmentMapper {
    public static Appointment toDomain(AppointmentEntity entity) {
        Appointment appointment = new Appointment();
        appointment.setAppointmentId(entity.getAppointmentId());
        appointment.setReservedAt(entity.getReservedAt());
        appointment.setStatus(entity.getStatus());
        appointment.setSlotId(entity.getSlotId());
        appointment.setDoctorId(entity.getDoctorId());

        if (entity.getPatient() != null) {
            appointment.setPatient(PatientMapper.toDomain(entity.getPatient()));
        }
        return appointment;
    }

    public static AppointmentEntity toEntity(Appointment appointment) {
        AppointmentEntity entity = new AppointmentEntity();
        entity.setAppointmentId(appointment.getAppointmentId());
        entity.setReservedAt(appointment.getReservedAt());
        entity.setStatus(appointment.getStatus());
        entity.setSlotId(appointment.getSlotId());
        entity.setDoctorId(appointment.getDoctorId());

        if (appointment.getPatient() != null) {
            entity.setPatient(PatientMapper.toEntity(appointment.getPatient()));
        }
        return entity;
    }
    public static AppointmentDTO toDTO(AppointmentEntity entity) {
        AppointmentDTO dto = new AppointmentDTO();
        dto.setAppointmentId(entity.getAppointmentId());
        dto.setReservedAt(entity.getReservedAt());
        dto.setStatus(entity.getStatus());
        dto.setSlotId(entity.getSlotId());
        dto.setDoctorId(entity.getDoctorId());

        if (entity.getPatient() != null) {
            dto.setPatient(PatientMapper.toDTO(entity.getPatient()));
        }
        return dto;
    }

}