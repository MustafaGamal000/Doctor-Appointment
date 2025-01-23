package com.booking.appointment_management.shell.adapters;

import com.booking.appointment_management.core.domain.Doctor;
import com.booking.appointment_management.core.port.IDoctorRepository;
import com.booking.appointment_management.shell.mappers.DoctorMapper;
import com.booking.doctor_avalibality.shared.contract.IDoctorAvailability;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ManagementDoctorRepository implements IDoctorRepository {
    private final IDoctorAvailability doctorRepository;

    public ManagementDoctorRepository(IDoctorAvailability doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public Doctor findDoctorById(UUID doctorId) {
        return DoctorMapper.toDomain(doctorRepository.findDoctorById(doctorId));
    }
}
