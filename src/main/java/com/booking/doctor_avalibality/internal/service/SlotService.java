package com.booking.doctor_avalibality.internal.service;

import com.booking.doctor_avalibality.shared.dtos.SlotDTO;
import com.booking.doctor_avalibality.internal.mapper.SlotMapper;
import com.booking.doctor_avalibality.internal.controller.slot.request.SlotRequest;
import com.booking.doctor_avalibality.internal.controller.slot.response.SlotResponse;
import com.booking.doctor_avalibality.internal.entities.DoctorEntity;
import com.booking.doctor_avalibality.internal.repository.DoctorRepository;
import com.booking.doctor_avalibality.internal.repository.SlotRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SlotService {

    private final SlotRepository slotRepository;
    private final DoctorRepository doctorRepository;

    public SlotService(SlotRepository slotRepository, DoctorRepository doctorRepository) {
        this.slotRepository = slotRepository;
        this.doctorRepository = doctorRepository;
    }

    public List<SlotDTO> getReservedSlots(boolean status) {
        return slotRepository.findByIsReserved(status).stream()
                .map(SlotMapper::toDTO)
                .collect(Collectors.toList());
    }

    public SlotResponse addSlot(SlotRequest request) {
        DoctorEntity doctor = doctorRepository.findByDoctorName(request.getDoctorName())
                .orElseGet(() -> {
                    DoctorEntity newDoctor = new DoctorEntity();
                    newDoctor.setDoctorName(request.getDoctorName());
                    return doctorRepository.save(newDoctor);
                });

        SlotDTO slotDTO = new SlotDTO();
        slotDTO.setTime(request.getTime());
        slotDTO.setCost(request.getCost());
        slotDTO.setDoctorId(doctor.getDoctorId());
        slotDTO.setReserved(false);

        slotRepository.save(SlotMapper.toEntity(slotDTO));
        return SlotResponse.createSlotResponse("New slot added to doctor name: " + request.getDoctorName(),
                "Slot Created",
                request.getCost());
    }


    // For Testing Only, it is implemented in DoctorAvailability in shared package
//    public void reserveSlot(ReserveSlotDTO request) {
//        UUID slotId = request.getSlotId();
//
//        SlotEntity slot = slotRepository.findById(slotId)
//                .orElseThrow(() -> new IllegalArgumentException("Slot with ID " + slotId + " not found."));
//
//        if (slot.isReserved()) {
//            throw new IllegalArgumentException("Slot is already reserved.");
//        }
//
//        slot.setReserved(true);
//        slot.setReservedAt(LocalDateTime.now());
//
//        slotRepository.save(slot);
//    }
}
