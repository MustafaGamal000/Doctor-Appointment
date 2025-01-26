package com.booking.doctor_avalibality.internal.service;

import com.booking.doctor_avalibality.internal.entities.DoctorEntity;
import com.booking.doctor_avalibality.internal.exceptions.DoctorNotFoundException;
import com.booking.doctor_avalibality.internal.repository.DoctorRepository;
import com.booking.doctor_avalibality.internal.controller.mapper.DoctorMapper;
import com.booking.doctor_avalibality.shared.dtos.DoctorDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorAvailabilityRepository) {
        this.doctorRepository = doctorAvailabilityRepository;
    }

    public List<DoctorDTO> getAllDoctors() {
        return doctorRepository.findAll()
                .stream()
                .map(DoctorMapper::toDTO)
                .collect(Collectors.toList());
    }

    public DoctorDTO getSlotsByDoctorName(String doctorName) {
        DoctorEntity doctorEntities = doctorRepository.findByDoctorName(doctorName)
                .orElseThrow(() -> new DoctorNotFoundException("Doctor with name \'" + doctorName + "\' not found."));

        return DoctorMapper.toDTO(doctorEntities);
    }

}
