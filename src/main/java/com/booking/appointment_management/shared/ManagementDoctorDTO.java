package com.booking.appointment_management.shared;

import java.util.List;

public class ManagementDoctorDTO {
    private String doctorName;
    private List<ManagementSlotDTO> slots;

    public ManagementDoctorDTO(String doctorName, List<ManagementSlotDTO> slots) {
        this.doctorName = doctorName;
        this.slots = slots;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public List<ManagementSlotDTO> getSlots() {
        return slots;
    }

    public void setSlots(List<ManagementSlotDTO> slots) {
        this.slots = slots;
    }
}
