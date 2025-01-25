package com.booking.appointment_management.shell.mappers;

import com.booking.appointment_management.core.domain.Appointment;
import com.booking.appointment_management.core.domain.Doctor;
import com.booking.appointment_management.core.domain.Patient;
import com.booking.appointment_management.core.domain.Slot;
import com.booking.appointment_management.shared.ManagementAppointmentDTO;
import com.booking.appointment_management.shared.ManagementDoctorDTO;
import com.booking.appointment_management.shared.ManagementPatientDTO;
import com.booking.appointment_management.shared.ManagementSlotDTO;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public class ManagementMapper {
    public static ManagementDoctorDTO toManagementDoctorDTO(Doctor doctor, Map<UUID, List<Appointment>> appointmentsBySlot) {
        List<ManagementSlotDTO> slotDTOs = doctor.getSlots().stream()
                .filter(slot -> appointmentsBySlot.containsKey(slot.getSlotId()))
                .map(slot -> toManagementSlotDTO(slot, appointmentsBySlot.get(slot.getSlotId())))
                .collect(Collectors.toList());

        return new ManagementDoctorDTO(doctor.getDoctorName(), slotDTOs);
    }

    private static ManagementSlotDTO toManagementSlotDTO(Slot slot, List<Appointment> appointments) {
        List<ManagementAppointmentDTO> appointmentDTOs = appointments.stream()
                .map(ManagementMapper::toManagementAppointmentDTO)
                .collect(Collectors.toList());

        return new ManagementSlotDTO(slot.getTime(), slot.getCost(), appointmentDTOs);
    }

    private static ManagementAppointmentDTO toManagementAppointmentDTO(Appointment appointment) {
        return new ManagementAppointmentDTO(
                appointment.getAppointmentId(),
                appointment.getReservedAt(),
                appointment.getStatus().toString(),
                toManagementPatientDTO(appointment.getPatient())
        );
    }

    private static ManagementPatientDTO toManagementPatientDTO(Patient patient) {
        return new ManagementPatientDTO(patient.getPatientId(), patient.getPatientName());
    }
}
