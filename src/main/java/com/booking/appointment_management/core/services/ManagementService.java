package com.booking.appointment_management.core.services;

import com.booking.appointment_management.core.domain.Appointment;
import com.booking.appointment_management.core.domain.Doctor;
import com.booking.appointment_management.core.port.IAppointmentRepository;
import com.booking.appointment_management.core.port.IDoctorRepository;
import com.booking.shared.AppointmentStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ManagementService {
    private final IAppointmentRepository appointmentRepository;
    private final IDoctorRepository doctorRepository;

    public ManagementService(IAppointmentRepository appointmentRepository, IDoctorRepository doctorRepository) {
        this.appointmentRepository = appointmentRepository;
        this.doctorRepository = doctorRepository;
    }


    public Map<Doctor, Map<UUID, List<Appointment>>> getUpcomingAppointment(UUID doctorId) {
        List<Appointment> appointments = appointmentRepository.findAppointmentByDoctorId(doctorId);

        Doctor doctor = doctorRepository.findDoctorById(doctorId);


        Map<UUID, List<Appointment>> appointmentsBySlot = appointments.stream()
                .collect(Collectors.groupingBy(Appointment::getSlotId));

        return Map.of(doctor, appointmentsBySlot);
    }

    public String changeCurrentStatus(UUID appointmentId, AppointmentStatus status){
        int updatedRows = appointmentRepository.updateStatusById(appointmentId, status);

        if (updatedRows == 0) {
            throw new IllegalArgumentException("Appointment not found");
        }

        return "Appointment status updated successfully to " + status;
    }
}
