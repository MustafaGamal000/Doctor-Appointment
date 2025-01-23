package com.booking.Appointment_booking.internal.domain.contract;

import com.booking.Appointment_booking.internal.domain.models.Appointment;

import java.util.List;
import java.util.UUID;

public interface AppointmentRepository {
    void save(Appointment appointment);
    List<Appointment> findByDoctorId(UUID doctorId);

}
