package com.booking.Appointment_booking.shared.contract;

import com.booking.Appointment_booking.shared.dto.AppointmentDTO;

import java.util.List;
import java.util.UUID;

public interface IAppointmentBooking {
    List<AppointmentDTO> findByDoctorId(UUID doctorId);
}
