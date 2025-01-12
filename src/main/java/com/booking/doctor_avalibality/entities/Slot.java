package com.booking.doctor_avalibality.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Slots")
public class Slot {

    @Id
    @GeneratedValue
    private UUID slotId;

    @Column(nullable = false)
    private LocalDateTime time;

    @ManyToOne
    @JoinColumn(name = "doctor_id", referencedColumnName = "doctorId", nullable = false)
    @JsonBackReference
    private Doctor doctor;

    @Column(nullable = false)
    private boolean isReserved;

    private LocalDateTime reservedAt;

    private BigDecimal cost;

    @OneToMany(mappedBy = "slot", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Appointment> appointments;

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

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
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

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}