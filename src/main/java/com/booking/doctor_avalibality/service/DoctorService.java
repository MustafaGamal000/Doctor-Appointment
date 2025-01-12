package com.booking.doctor_avalibality.service;

import com.booking.doctor_avalibality.entities.Doctor;
import com.booking.doctor_avalibality.exceptions.DoctorNotFoundException;
import com.booking.doctor_avalibality.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor getSlotsByDoctorName(String name) {
        Optional<Doctor> doctor = doctorRepository.findByDoctorName(name);

        if(doctor.isEmpty())
            throw new DoctorNotFoundException("Doctor with name \'" + name + "\' not found.");
        return doctor.get();
    }
}
