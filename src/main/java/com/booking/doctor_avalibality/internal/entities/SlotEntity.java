package com.booking.doctor_avalibality.internal.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "Slots")
public class SlotEntity {

    @Id
    @GeneratedValue
    private UUID slotId;

    @Column(nullable = false)
    private LocalDateTime time;

    @ManyToOne
    @JoinColumn(name = "doctor_id", referencedColumnName = "doctorId", nullable = false)
    @JsonBackReference
    private DoctorEntity doctor;

    @Column(nullable = false)
    private boolean isReserved;

    private LocalDateTime reservedAt;

    private BigDecimal cost;

    public UUID getSlotId() {
        return slotId;
    }

    public void setSlotId(UUID slotId) {
        this.slotId = slotId;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public DoctorEntity getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorEntity doctor) {
        this.doctor = doctor;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public LocalDateTime getReservedAt() {
        return reservedAt;
    }

    public void setReservedAt(LocalDateTime reservedAt) {
        this.reservedAt = reservedAt;
    }
}