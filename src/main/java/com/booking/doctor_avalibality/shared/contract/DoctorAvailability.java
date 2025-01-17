package com.booking.doctor_avalibality.shared.contract;

import com.booking.doctor_avalibality.shared.dtos.ReserveSlotDTO;
import com.booking.doctor_avalibality.internal.entities.SlotEntity;
import com.booking.doctor_avalibality.internal.mapper.SlotMapper;
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

    public DoctorAvailability(SlotRepository slotRepository) {
        this.slotRepository = slotRepository;
    }

    @Override
    public List<SlotDTO> getFreeSlots(boolean state) {
        return slotRepository.findByIsReserved(state)
                .stream()
                .map(SlotMapper::toDTO)
                .collect(Collectors.toList());
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
