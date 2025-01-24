package com.booking.appointment_management.shell.mappers;

import com.booking.appointment_management.core.domain.Slot;
import com.booking.doctor_avalibality.shared.dtos.SlotDTO;

public class SlotMapper {
    public static Slot toDomain(SlotDTO dto) {
        Slot slot = new Slot();
        slot.setSlotId(dto.getSlotId());
        slot.setTime(dto.getTime());
        slot.setCost(dto.getCost());
        return slot;
    }
}
