package com.booking.appointment_confirmation.internal;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.booking.appointment_confirmation.shared.NotificationEvent;

@Component
public class NotificationEventListener {

    @EventListener
    public void sendNotification(NotificationEvent event) {
        System.out.println(
            "Sending notification with message [%s] to [%s]".formatted(
                event.message(),
                event.receiver()
            )
        );
    }
}
