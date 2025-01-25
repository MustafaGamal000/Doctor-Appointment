package com.booking.Appointment_booking.internal.infrastructue.events;

import com.booking.Appointment_booking.internal.domain.events.IAppointmentEventPublisher;
import com.booking.Appointment_booking.internal.domain.models.Appointment;
import com.booking.Appointment_booking.shared.event.AppointmentCreatedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class AppointmentEventPublisher implements IAppointmentEventPublisher {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void publishAppointmentCreatedEvent(Appointment appointment) {
        System.out.println("Publishing custom event. ");

        AppointmentCreatedEvent appointmentCreatedEvent = new AppointmentCreatedEvent(appointment.getAppointmentId(),
                appointment.getSlotId(),
                appointment.getPatient().getPatientId(),
                appointment.getPatient().getPatientName(),
                appointment.getReservedAt());

        applicationEventPublisher.publishEvent(appointmentCreatedEvent);
    }

}
