package com.booking.appointment_management.core.port;

import com.booking.appointment_management.core.domain.Appointment;
import com.booking.shared.AppointmentStatus;

import java.util.List;
import java.util.UUID;

public interface IAppointmentRepository {
    List<Appointment> findAppointmentByDoctorId(UUID doctorId);
    int updateStatusById(UUID appointmentId, AppointmentStatus status);
}
