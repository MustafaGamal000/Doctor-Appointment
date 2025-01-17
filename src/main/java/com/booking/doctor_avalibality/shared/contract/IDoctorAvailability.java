package com.booking.doctor_avalibality.shared.contract;

import com.booking.doctor_avalibality.shared.dtos.DoctorDTO;
import com.booking.doctor_avalibality.shared.dtos.ReserveSlotDTO;
import com.booking.doctor_avalibality.shared.dtos.SlotDTO;

import java.util.List;

public interface IDoctorAvailability {
    List<SlotDTO> getFreeSlots(boolean state);
    void reserveSlot(ReserveSlotDTO request);
}
