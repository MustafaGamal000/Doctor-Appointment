package com.booking.doctor_avalibality.repository;

import com.booking.doctor_avalibality.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, UUID> {
    Optional<Doctor> findByDoctorName(String name);
}
