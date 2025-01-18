package com.booking.doctor_avalibality.internal.controller.doctor;

import com.booking.doctor_avalibality.internal.service.DoctorService;
import com.booking.doctor_avalibality.shared.dtos.DoctorDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/doctor-availability/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorAvailabilityService) {
        this.doctorService = doctorAvailabilityService;
    }

    @GetMapping("/{name}")
    public DoctorDTO getAllSlots(@PathVariable String name) {
        return doctorService.getSlotsByDoctorName(name);
    }

}
