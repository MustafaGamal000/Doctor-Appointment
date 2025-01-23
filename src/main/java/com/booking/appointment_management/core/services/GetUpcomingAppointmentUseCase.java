package com.booking.appointment_management.core.services;

import com.booking.appointment_management.core.domain.Appointment;
import com.booking.appointment_management.core.domain.Doctor;
import com.booking.appointment_management.core.port.IAppointmentRepository;
import com.booking.appointment_management.core.port.IDoctorRepository;
import com.booking.appointment_management.core.dtos.UpcomingAppointmentDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class GetUpcomingAppointmentUseCase {
    private final IAppointmentRepository appointmentRepository;
    private final IDoctorRepository doctorRepository;

    public GetUpcomingAppointmentUseCase(IAppointmentRepository appointmentRepository, IDoctorRepository doctorRepository) {
        this.appointmentRepository = appointmentRepository;
        this.doctorRepository = doctorRepository;
    }


    public List<UpcomingAppointmentDTO> execute(UUID doctorId) {
        List<Appointment> appointments = appointmentRepository.findAppointmentByDoctorId(doctorId);

        Doctor doctor = doctorRepository.findDoctorById(doctorId);
        System.out.println("Size of slots appointment management: " + doctor.getSlots().size());

        return appointments.stream()
                .map(appointment -> new UpcomingAppointmentDTO(
                        appointment.getAppointmentId(),
                        appointment.getPatient().getPatientName(),
                        appointment.getReservedAt(),
                        appointment.getStatus().toString(),
                        doctor.getDoctorName(),
                        doctor.getSlots()
                ))
                .collect(Collectors.toList());
    }
}
