package com.booking.doctor_avalibality.shared.contract;

import com.booking.doctor_avalibality.internal.repository.DoctorRepository;
import com.booking.doctor_avalibality.shared.dtos.DoctorDTO;
import com.booking.doctor_avalibality.shared.dtos.ReserveSlotDTO;
import com.booking.doctor_avalibality.internal.entities.SlotEntity;
import com.booking.doctor_avalibality.shared.mapper.DoctorMapper;
import com.booking.doctor_avalibality.shared.mapper.SlotMapper;
import com.booking.doctor_avalibality.internal.repository.SlotRepository;
import com.booking.doctor_avalibality.shared.dtos.SlotDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DoctorAvailability implements IDoctorAvailability {
    private final SlotRepository slotRepository;
    private final DoctorRepository doctorRepository;

    public DoctorAvailability(SlotRepository slotRepository, DoctorRepository doctorRepository) {
        this.slotRepository = slotRepository;
        this.doctorRepository = doctorRepository;
    }

    @Override
    public List<SlotDTO> getFreeSlots(boolean state) {
        return slotRepository.findByIsReserved(state)
                .stream()
                .map(SlotMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DoctorDTO getFreeSlotsByDoctorName(String doctorName) {
        return doctorRepository.findByDoctorName(doctorName)
                .map(doctorEntity -> {
                    DoctorDTO doctorDTO = DoctorMapper.toDTO(doctorEntity);

                    List<SlotDTO> freeSlots = doctorDTO.getSlots().stream()
                            .filter(slot -> !slot.isReserved())
                            .collect(Collectors.toList());

                    doctorDTO.setSlots(freeSlots);

                    return doctorDTO;
                })
                .orElseThrow(() -> new IllegalArgumentException("Doctor with name " + doctorName + " not found."));
    }

    @Override
    public void reserveSlot(ReserveSlotDTO request) {
        UUID slotId = request.getSlotId();

        SlotEntity slot = slotRepository.findById(slotId)
                .orElseThrow(() -> new IllegalArgumentException("Slot with ID " + slotId + " not found."));

        if (slot.isReserved()) {
            throw new IllegalArgumentException("Slot is already reserved.");
        }

        slot.setReserved(true);
        slot.setReservedAt(LocalDateTime.now());

        slotRepository.save(slot);
    }
}
