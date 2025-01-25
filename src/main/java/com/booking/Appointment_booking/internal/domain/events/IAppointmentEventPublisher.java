package com.booking.Appointment_booking.internal.domain.events;

import com.booking.Appointment_booking.internal.domain.models.Appointment;

public interface IAppointmentEventPublisher {
    void publishAppointmentCreatedEvent(Appointment appointment);
}
