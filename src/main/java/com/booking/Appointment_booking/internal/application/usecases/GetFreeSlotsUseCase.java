package com.booking.Appointment_booking.internal.application.usecases;

import com.booking.doctor_avalibality.shared.contract.IDoctorAvailability;
import com.booking.doctor_avalibality.shared.dtos.SlotDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetFreeSlotsUseCase {
    private final IDoctorAvailability doctorAvailability;

    public GetFreeSlotsUseCase(IDoctorAvailability doctorAvailability) {
        this.doctorAvailability = doctorAvailability;
    }

    public List<SlotDTO> getFreeSlots() {
        return doctorAvailability.getFreeSlots();
    }
}
