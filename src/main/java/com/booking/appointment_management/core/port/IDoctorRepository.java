package com.booking.appointment_management.core.port;

import com.booking.appointment_management.core.domain.Doctor;

import java.util.UUID;

public interface IDoctorRepository {
    Doctor findDoctorById(UUID doctorId);

}
