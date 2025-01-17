package com.booking.doctor_avalibality.internal.controller;

import com.booking.doctor_avalibality.shared.dtos.DoctorSlotDTO;
import com.booking.doctor_avalibality.internal.service.DoctorAvailabilityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/doctor-availability")
public class DoctorController {

    private final DoctorAvailabilityService doctorAvailabilityService;

    public DoctorController(DoctorAvailabilityService doctorAvailabilityService) {
        this.doctorAvailabilityService = doctorAvailabilityService;
    }

    @GetMapping("/{doctorId}")
    public List<DoctorSlotDTO> getSlots(@PathVariable UUID doctorId) {
        return doctorAvailabilityService.getSlotsByDoctorID(doctorId);
    }

    @PostMapping
    public DoctorSlotDTO addSlot(@RequestBody DoctorSlotDTO slot) {
        return doctorAvailabilityService.addSlot(slot);
    }
}
