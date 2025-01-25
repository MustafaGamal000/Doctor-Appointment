package com.booking.appointment_confirmation;

import com.booking.Appointment_booking.shared.event.AppointmentCreatedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationEventListener {

    @EventListener
    public void sendNotification(AppointmentCreatedEvent event) {
        System.out.println("Sending confirmation notification for appointment ID: " + event.appointmentId());
        System.out.println("Slot ID: " + event.slotId());
        System.out.println("Patient ID: " + event.patientId());
        System.out.println("Patient Name: " + event.patientName());
        System.out.println("Appointment Time: " + event.reservedAt());
    }
}
