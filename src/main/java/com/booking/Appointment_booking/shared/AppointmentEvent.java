package com.booking.Appointment_booking.shared;

import java.time.LocalDateTime;
import java.util.UUID;

public record AppointmentEvent(UUID appointmentId,
                               UUID slotId,
                               UUID patientId,
                               String patientName,
                               LocalDateTime reservedAt)
{

}
