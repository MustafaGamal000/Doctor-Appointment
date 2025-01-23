package com.booking.appointment_management.core.port;

import com.booking.appointment_management.core.domain.Appointment;

import java.util.List;
import java.util.UUID;

public interface IAppointmentRepository {
    List<Appointment> findAppointmentByDoctorId(UUID doctorId);
}
