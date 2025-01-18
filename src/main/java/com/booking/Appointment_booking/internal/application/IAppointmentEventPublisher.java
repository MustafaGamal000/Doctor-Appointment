package com.booking.Appointment_booking.internal.application;

import com.booking.Appointment_booking.internal.domain.models.AppointmentEvent;

public interface IAppointmentEventPublisher {
    void publishCustomEvent(AppointmentEvent event);
}
