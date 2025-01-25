package com.booking.appointment_management.shell.mappers;

import com.booking.appointment_management.core.domain.Doctor;
import com.booking.doctor_avalibality.shared.dtos.DoctorDTO;

import java.util.stream.Collectors;

public class DoctorMapper {
    public static Doctor toDomain(DoctorDTO dto) {
        Doctor doctor = new Doctor();
        doctor.setDoctorId(dto.getDoctorId());
        doctor.setDoctorName(dto.getDoctorName());
        if (dto.getSlots() != null) {
            doctor.setSlots(dto.getSlots().stream()
                    .map(SlotMapper::toDomain)
                    .collect(Collectors.toList()));
        }
        return doctor;
    }
}
