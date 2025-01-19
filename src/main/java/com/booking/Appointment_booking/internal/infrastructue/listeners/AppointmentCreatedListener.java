package com.booking.Appointment_booking.internal.infrastructue.listeners;

import com.booking.Appointment_booking.shared.AppointmentEvent;
import org.springframework.context.event.EventListener;

public class AppointmentCreatedListener {

    @EventListener
    public void sendNotification(AppointmentEvent event) {
        System.out.println("AppointmentCreated fired!!");


    }

}
