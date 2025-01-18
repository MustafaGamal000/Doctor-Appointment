package com.booking.Appointment_booking.internal.infrastructue.listeners;

import com.booking.Appointment_booking.internal.domain.models.AppointmentCreated;
import com.booking.appointment_confirmation.shared.NotificationEvent;
import org.springframework.context.event.EventListener;

public class AppointmentCreatedListener {

    @EventListener
    public void sendNotification(AppointmentCreated event) {
        System.out.println("AppointmentCreated fired!!");


    }

}
