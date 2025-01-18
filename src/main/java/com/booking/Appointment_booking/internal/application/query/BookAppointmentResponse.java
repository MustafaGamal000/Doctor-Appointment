package com.booking.Appointment_booking.internal.application.query;

import java.util.UUID;

public class BookAppointmentResponse {
    private final UUID appointmentId;
    private final UUID slotId;
    private final String message;

    public BookAppointmentResponse(UUID appointmentId, UUID slotId, String message) {
        this.appointmentId = appointmentId;
        this.slotId = slotId;
        this.message = message;
    }

    public UUID getAppointmentId() {
        return appointmentId;
    }

    public UUID getSlotId() {
        return slotId;
    }

    public String getMessage() {
        return message;
    }
}
