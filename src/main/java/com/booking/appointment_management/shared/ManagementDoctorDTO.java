package com.booking.appointment_management.shared;

import java.util.List;

public class ManagementDoctorDTO {
    private  List<ManagementSlotDTO> slotDTOs;
    private String doctorName;

    public List<ManagementSlotDTO> getSlotDTOs() {
        return slotDTOs;
    }

    public void setSlotDTOs(List<ManagementSlotDTO> slotDTOs) {
        this.slotDTOs = slotDTOs;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public ManagementDoctorDTO(String doctorName, List<ManagementSlotDTO> slotDTOs) {
        this.doctorName = doctorName;
        this.slotDTOs = slotDTOs;
    }
}
