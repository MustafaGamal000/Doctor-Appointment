package com.booking.Appointment_booking.internal.infrastructue.events;

import com.booking.Appointment_booking.shared.AppointmentEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class AppointmentEventPublisher implements IAppointmentEventPublisher {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void publishCustomEvent(AppointmentEvent event) {
        System.out.println("Publishing custom event. ");

        //TODO We need to create infrastructe event that take this event to publish it
//        AppointmentEvent appointmentCreatedEvent = new AppointmentCreated();
        applicationEventPublisher.publishEvent(event);
    }

}
