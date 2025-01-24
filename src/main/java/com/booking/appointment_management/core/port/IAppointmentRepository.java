package com.booking.appointment_management.core.port;

import com.booking.Appointment_booking.internal.shared.AppointmentStatus;
import com.booking.appointment_management.core.domain.Appointment;

import java.util.List;
import java.util.UUID;

public interface IAppointmentRepository {
    List<Appointment> findAppointmentByDoctorId(UUID doctorId);
    int updateStatusById(UUID appointmentId, AppointmentStatus status);


}
