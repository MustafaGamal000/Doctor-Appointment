package com.booking.doctor_avalibality.shared.contract;

import com.booking.doctor_avalibality.shared.dtos.DoctorDTO;
import com.booking.doctor_avalibality.shared.dtos.SlotDTO;

import java.util.List;
import java.util.UUID;

public interface IDoctorAvailability {
    List<SlotDTO> getFreeSlots();
    DoctorDTO getFreeSlotsByDoctorName(String doctorName);
    UUID reserveSlot(UUID slotId);
    DoctorDTO findDoctorById(UUID doctorId);
}
