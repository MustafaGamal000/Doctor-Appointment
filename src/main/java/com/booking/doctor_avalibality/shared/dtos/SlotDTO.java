package com.booking.doctor_avalibality.shared.dtos;

import com.booking.doctor_avalibality.internal.entities.DoctorEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class SlotDTO {
    private UUID slotId;
    private LocalDateTime time;
    private UUID doctorId;
    @JsonIgnore
    private boolean isReserved;
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

    @JsonIgnore
    public boolean isReserved() {
        return isReserved;
    }

    @JsonIgnore
    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
}
