package com.booking.doctor_avalibality.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Doctors")
public class Doctor {

    @Id
    @GeneratedValue
    private UUID doctorId;

    @Column(nullable = false)
    private String doctorName;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Slot> slots;

    public UUID getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(UUID doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public void setSlots(List<Slot> slots) {
        this.slots = slots;
    }
}
