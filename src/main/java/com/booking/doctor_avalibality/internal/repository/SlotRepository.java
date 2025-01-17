package com.booking.doctor_avalibality.internal.repository;

import com.booking.doctor_avalibality.internal.entities.DoctorEntity;
import com.booking.doctor_avalibality.internal.entities.SlotEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SlotRepository extends JpaRepository<SlotEntity, UUID> {
    List<SlotEntity> findByIsReserved(boolean state);

}
