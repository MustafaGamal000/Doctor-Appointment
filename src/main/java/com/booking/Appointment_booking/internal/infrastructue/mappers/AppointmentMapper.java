package com.booking.Appointment_booking.internal.infrastructue.mappers;

import com.booking.Appointment_booking.internal.domain.models.Appointment;
import com.booking.Appointment_booking.internal.infrastructue.entities.AppointmentEntity;

public class AppointmentMapper {
    public static Appointment toDomain(AppointmentEntity entity) {
        Appointment appointment = new Appointment();
        appointment.setAppointmentId(entity.getAppointmentId());
        appointment.setReservedAt(entity.getReservedAt());
        appointment.setStatus(entity.getStatus());
        appointment.setSlotId(entity.getSlotId());

        // Map patient if needed (assuming PatientMapper is available)
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

        // Map patient if needed (assuming PatientMapper is available)
        if (appointment.getPatient() != null) {
            entity.setPatient(PatientMapper.toEntity(appointment.getPatient()));
        }
        return entity;
    }
}