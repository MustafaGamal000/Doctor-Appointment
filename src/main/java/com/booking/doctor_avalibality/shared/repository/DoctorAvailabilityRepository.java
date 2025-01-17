package com.booking.doctor_avalibality.shared.repository;

import com.booking.doctor_avalibality.internal.entities.DoctorSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DoctorAvailabilityRepository extends JpaRepository<DoctorSlot, UUID> {
    List<DoctorSlot> findByDoctorId(UUID doctorId);
}
