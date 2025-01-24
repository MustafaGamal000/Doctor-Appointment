package com.booking.appointment_management.core.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Slot {
    private UUID slotId;
    private LocalDateTime time;
    private BigDecimal cost;

    public Slot() {
    }

    public Slot(UUID slotId, LocalDateTime time, BigDecimal cost) {
        this.slotId = slotId;
        this.time = time;
        this.cost = cost;
    }

    public UUID getSlotId() {
        return slotId;
    }

    public void setSlotId(UUID slotId) {
        this.slotId = slotId;
    }

    public LocalDateTime getTime() {
        return time;
    }
    public void setTime(LocalDateTime time) {
        this.time = time;
    }
    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
}
