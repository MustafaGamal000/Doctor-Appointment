package com.booking.doctor_avalibality.internal.controller.slot;

import com.booking.doctor_avalibality.internal.controller.slot.request.SlotRequest;
import com.booking.doctor_avalibality.internal.controller.slot.response.SlotResponse;
import com.booking.doctor_avalibality.internal.service.SlotService;
import com.booking.doctor_avalibality.shared.dtos.SlotDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctor-availability/slots")
public class SlotController {
    private final SlotService slotService;

    public SlotController(SlotService slotService) {
        this.slotService = slotService;
    }

    @PostMapping
    public ResponseEntity<SlotResponse> addSlot(@RequestBody SlotRequest slot) {
        slotService.addSlot(slot);
        SlotResponse response = SlotResponse.createSlotResponse("New slot added to doctor name: " + slot.getDoctorName(),
                "Slot Created",
                slot.getCost()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // Testing Only
    @GetMapping("/{status}")
    public List<SlotDTO> findReservedSlots(@PathVariable boolean status) {
        return slotService.getReservedSlots(status);
    }

    // Testing Only
//    @PostMapping("/reserve")
//    public ResponseEntity<String> reserveSlot(@RequestBody ReserveSlotDTO request) {
//        slotService.reserveSlot(request);
//        return ResponseEntity.ok("Slot reserved successfully.");
//    }
}
