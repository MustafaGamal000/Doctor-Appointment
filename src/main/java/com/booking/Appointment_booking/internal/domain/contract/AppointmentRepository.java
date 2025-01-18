package com.booking.Appointment_booking.internal.domain.contract;

import com.booking.Appointment_booking.internal.domain.models.Appointment;

import java.util.UUID;

public interface AppointmentRepository {
    void save(Appointment appointment);
}
