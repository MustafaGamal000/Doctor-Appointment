package com.booking.Appointment_booking.internal.api;

import com.booking.Appointment_booking.internal.application.query.BookAppointmentRequest;
import com.booking.Appointment_booking.internal.application.query.BookAppointmentResponse;
import com.booking.Appointment_booking.internal.application.usecases.GetFreeSlotsUseCase;
import com.booking.Appointment_booking.internal.application.usecases.ReserveSlotUseCase;
import com.booking.doctor_avalibality.shared.dtos.SlotDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointment-booking")
public class AppointmentController {

    private final GetFreeSlotsUseCase getFreeSlotsUseCase;
    private final ReserveSlotUseCase reserveSlotUseCase;

    public AppointmentController(GetFreeSlotsUseCase getFreeSlotsUseCase, ReserveSlotUseCase reserveSlotUseCase) {
        this.getFreeSlotsUseCase = getFreeSlotsUseCase;
        this.reserveSlotUseCase = reserveSlotUseCase;
    }

    @GetMapping("/free-slots")
    public List<SlotDTO> getFreeSlots() {
        return getFreeSlotsUseCase.getFreeSlots();
    }

    @PostMapping("/book")
    public BookAppointmentResponse bookAppointment(@RequestBody BookAppointmentRequest request) {
        return reserveSlotUseCase.reserveSlot(request);
    }
}
