package com.booking.Appointment_booking.internal.application.query;

import java.util.UUID;

public class BookAppointmentResponse {
    private final UUID appointmentId;
    private final UUID doctorId;
    private final UUID slotId;
    private final String message;

    public BookAppointmentResponse(UUID appointmentId, UUID doctorId, UUID slotId, String message) {
        this.appointmentId = appointmentId;
        this.doctorId = doctorId;
        this.slotId = slotId;
        this.message = message;
    }

    public UUID getDoctorId() {
        return doctorId;
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
