package com.booking.appointment_management.shell.mappers;

import com.booking.Appointment_booking.shared.dto.AppointmentDTO;
import com.booking.appointment_management.core.domain.Appointment;
import com.booking.appointment_management.core.domain.Slot;
import com.booking.doctor_avalibality.shared.dtos.SlotDTO;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AppointmentMapper {
    public static List<Appointment> toDomain(List<AppointmentDTO> appointmentDTOs, List<SlotDTO> slotDTOs) {
        Map<UUID, Slot> slots = slotDTOs.stream()
                .map(SlotMapper::toDomain)
                .collect(Collectors.toMap(Slot::getSlotId, Function.identity(), (o1, o2) -> o1));

        return appointmentDTOs.stream().map(appointmentDTO -> {
            Appointment appointment = new Appointment();
            appointment.setAppointmentId(appointmentDTO.getAppointmentId());
            appointment.setStatus(appointmentDTO.getStatus());
            appointment.setPatient(PatientMapper.toDomain(appointmentDTO.getPatient()));
            appointment.setSlot(slots.get(appointmentDTO.getSlotId()));
            return appointment;
        }).toList();
    }

}