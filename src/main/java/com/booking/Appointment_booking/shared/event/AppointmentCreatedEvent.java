package com.booking.Appointment_booking.shared.event;

import java.time.LocalDateTime;
import java.util.UUID;

public record AppointmentCreatedEvent(UUID appointmentId,
                                      UUID doctorId,
                                      UUID slotId,
                                      UUID patientId,
                                      String patientName,
                                      LocalDateTime reservedAt)
{

}
