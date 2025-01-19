package com.booking.Appointment_booking.internal.infrastructue.events;

import com.booking.Appointment_booking.shared.AppointmentEvent;

public interface IAppointmentEventPublisher {
    void publishCustomEvent(AppointmentEvent event);
}
