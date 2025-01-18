package com.booking.Appointment_booking.internal.infrastructue;

import com.booking.Appointment_booking.internal.application.IAppointmentEventPublisher;
import com.booking.Appointment_booking.internal.domain.models.AppointmentEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;

public class AppointmentEventPublisher implements IAppointmentEventPublisher {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void publishCustomEvent(final AppointmentEvent event) {
        System.out.println("Publishing custom event. ");

        //TODO We need to create infrastructe event that take this event to publish it
//        AppointmentEvent appointmentCreatedEvent = new AppointmentCreated();
//        applicationEventPublisher.publishEvent(appointmentCreatedEvent);
    }

}
