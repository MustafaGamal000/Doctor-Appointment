package com.booking.doctor_avalibality.controller;

import com.booking.doctor_avalibality.entities.Doctor;
import com.booking.doctor_avalibality.service.DoctorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/get-all")
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @GetMapping("/{name}")
    public ResponseEntity<Doctor> getSlotsByDoctorName(@PathVariable String name){
        return ResponseEntity.ok(doctorService.getSlotsByDoctorName(name));
    }
}
