package com.booking.doctor_avalibality.shared.dtos;

import java.util.UUID;

public class ReserveSlotDTO {
    private UUID slotId;

    public UUID getSlotId() {
        return slotId;
    }

    public void setSlotId(UUID slotId) {
        this.slotId = slotId;
    }
}
