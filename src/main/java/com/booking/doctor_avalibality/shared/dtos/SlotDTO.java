package com.booking.doctor_avalibality.shared.dtos;

import com.booking.doctor_avalibality.internal.entities.DoctorEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class SlotDTO {
    private UUID slotId;
    private LocalDateTime time;
    private UUID doctorId;
    private boolean isReserved;
    private LocalDateTime reservedAt;
    private BigDecimal cost;

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

    public UUID getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(UUID doctorId) {
        this.doctorId = doctorId;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    public LocalDateTime getReservedAt() {
        return reservedAt;
    }

    public void setReservedAt(LocalDateTime reservedAt) {
        this.reservedAt = reservedAt;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
}
