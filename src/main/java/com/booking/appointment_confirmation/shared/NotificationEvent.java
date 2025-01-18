package com.booking.appointment_confirmation.shared;

public record NotificationEvent (
    String message,
    String receiver
) {
}
