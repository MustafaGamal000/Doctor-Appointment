package com.booking.doctor_avalibality.internal.repository;

import com.booking.doctor_avalibality.internal.entities.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorEntity, UUID> {
    Optional<DoctorEntity> findByDoctorName(String doctorName);
//    void reserveSlot(boolean state);
}
