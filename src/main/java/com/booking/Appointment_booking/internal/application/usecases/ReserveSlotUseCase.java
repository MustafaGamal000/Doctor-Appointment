package com.booking.Appointment_booking.internal.application.usecases;

import com.booking.Appointment_booking.internal.application.query.BookAppointmentRequest;
import com.booking.Appointment_booking.internal.application.query.BookAppointmentResponse;
import com.booking.Appointment_booking.internal.domain.contract.AppointmentRepository;
import com.booking.Appointment_booking.internal.domain.contract.PatientRepository;
import com.booking.Appointment_booking.internal.domain.models.Appointment;
import com.booking.Appointment_booking.internal.domain.models.Patient;
import com.booking.Appointment_booking.shared.AppointmentStatus;
import com.booking.doctor_avalibality.shared.contract.IDoctorAvailability;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class ReserveSlotUseCase {
    private final IDoctorAvailability doctorAvailability;
    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;


    public ReserveSlotUseCase(IDoctorAvailability doctorAvailability, AppointmentRepository appointmentRepository, PatientRepository patientRepository) {
        this.doctorAvailability = doctorAvailability;
        this.appointmentRepository = appointmentRepository;
        this.patientRepository = patientRepository;
    }

    public BookAppointmentResponse reserveSlot(BookAppointmentRequest request) {
        UUID slotId = request.getSlotId();
        doctorAvailability.reserveSlot(slotId);

        UUID patientId = request.getPatientId();
        Patient patient = patientRepository.findById(patientId)
                .orElseGet(() -> {
                    // If the patient doesn't exist, create a new one
                    Patient newPatient = new Patient(patientId, request.getPatientName());
                    patientRepository.save(newPatient);
                    return newPatient;
                });

        Appointment appointment = new Appointment();
        appointment.setAppointmentId(UUID.randomUUID());
        appointment.setReservedAt(LocalDateTime.now());
        appointment.setStatus(AppointmentStatus.OPENED);
        appointment.setPatient(patient);
        appointment.setSlotId(slotId);

        appointmentRepository.save(appointment);

        // Return the response
        return new BookAppointmentResponse(
                appointment.getAppointmentId(),
                slotId,
                "Appointment booked successfully."
        );
    }
}
