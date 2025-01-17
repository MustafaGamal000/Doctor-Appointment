package com.booking.doctor_avalibality.internal.service;

import com.booking.doctor_avalibality.shared.dtos.DoctorSlotDTO;
import com.booking.doctor_avalibality.internal.entities.DoctorSlot;
import com.booking.doctor_avalibality.internal.exceptions.DoctorNotFoundException;
import com.booking.doctor_avalibality.shared.repository.DoctorAvailabilityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DoctorAvailabilityService {
    private final DoctorAvailabilityRepository doctorAvailabilityRepository;

    public DoctorAvailabilityService(DoctorAvailabilityRepository doctorAvailabilityRepository) {
        this.doctorAvailabilityRepository = doctorAvailabilityRepository;
    }

    public List<DoctorSlot> getAllDoctors() {
        return doctorAvailabilityRepository.findAll();
    }

    public List<DoctorSlotDTO> getSlotsByDoctorID(UUID id) {
        List<DoctorSlot> slots = doctorAvailabilityRepository.findByDoctorId(id);

        if(slots.isEmpty())
            throw new DoctorNotFoundException("Doctor with ID \'" + id + "\' not found.");

        return slots.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public DoctorSlotDTO addSlot(DoctorSlotDTO slotDTO) {
        DoctorSlot slot = convertToEntity(slotDTO);
        slot.setId(UUID.randomUUID());
        doctorAvailabilityRepository.save(slot);
        return slotDTO;
    }

    private DoctorSlotDTO convertToDTO(DoctorSlot slot) {
        DoctorSlotDTO dto = new DoctorSlotDTO();
        dto.setId(slot.getId());
        dto.setTime(slot.getTime());
        dto.setDoctorId(slot.getDoctorId());
        dto.setDoctorName(slot.getDoctorName());
        dto.setReserved(slot.isReserved());
        dto.setCost(slot.getCost());
        return dto;
    }

    private DoctorSlot convertToEntity(DoctorSlotDTO dto) {
        DoctorSlot slot = new DoctorSlot();
        slot.setId(dto.getId());
        slot.setTime(dto.getTime());
        slot.setDoctorId(dto.getDoctorId());
        slot.setDoctorName(dto.getDoctorName());
        slot.setReserved(dto.isReserved());
        slot.setCost(dto.getCost());
        return slot;
    }
}
