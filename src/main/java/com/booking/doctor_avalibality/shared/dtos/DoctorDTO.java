package com.booking.doctor_avalibality.shared.dtos;

import java.util.List;
import java.util.UUID;

public class DoctorDTO {
    private UUID doctorId;
    private String doctorName;
    private List<SlotDTO> slots;

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

    public List<SlotDTO> getSlots() {
        return slots;
    }

    public void setSlots(List<SlotDTO> slots) {
        this.slots = slots;
    }
}
