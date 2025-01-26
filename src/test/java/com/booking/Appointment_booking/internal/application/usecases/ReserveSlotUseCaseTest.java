package com.booking.Appointment_booking.internal.application.usecases;

import com.booking.Appointment_booking.internal.application.query.BookAppointmentRequest;
import com.booking.Appointment_booking.internal.domain.contract.AppointmentRepository;
import com.booking.Appointment_booking.internal.domain.contract.PatientRepository;
import com.booking.Appointment_booking.internal.domain.events.IAppointmentEventPublisher;
import com.booking.Appointment_booking.internal.domain.models.Appointment;
import com.booking.Appointment_booking.internal.domain.models.Patient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.booking.shared.TestConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ReserveSlotUseCaseTest {
    @Mock
    private AppointmentRepository appointmentRepository;
    @Mock
    private PatientRepository patientRepository;
    @Mock
    private IAppointmentEventPublisher appointmentEventPublisher;

    @InjectMocks
    private ReserveSlotUseCase reserveSlotUseCase;

    @Test
    void reserveSlot_patientFound_test() {
        // Arrange
        BookAppointmentRequest bookAppointmentRequest = new BookAppointmentRequest();
        bookAppointmentRequest.setSlotId(SLOT_UUID);
        bookAppointmentRequest.setPatientId(PATIENT_UUID);
        bookAppointmentRequest.setPatientName(PATIENT_NAME);

        when(patientRepository.findById(PATIENT_UUID)).thenReturn(Optional.of(new Patient(PATIENT_UUID, PATIENT_NAME)));

        // Act
        var response = reserveSlotUseCase.reserveSlot(bookAppointmentRequest);

        // Assert
        verify(appointmentRepository).save(any(Appointment.class));
        verify(appointmentEventPublisher).publishAppointmentCreatedEvent(any(Appointment.class));
        verify(patientRepository, never()).save(any());
        assertEquals(response.getSlotId(), SLOT_UUID);
        assertEquals(response.getMessage(), "Appointment booked successfully.");
    }

    @Test
    void reserveSlot_patientNotFound_test() {
        // Arrange
        BookAppointmentRequest bookAppointmentRequest = new BookAppointmentRequest();
        bookAppointmentRequest.setSlotId(SLOT_UUID);
        bookAppointmentRequest.setPatientId(PATIENT_UUID);
        bookAppointmentRequest.setPatientName(PATIENT_NAME);

        when(patientRepository.findById(PATIENT_UUID)).thenReturn(Optional.empty());

        // Act
        var response = reserveSlotUseCase.reserveSlot(bookAppointmentRequest);

        // Assert
        verify(appointmentRepository).save(any(Appointment.class));
        verify(appointmentEventPublisher).publishAppointmentCreatedEvent(any(Appointment.class));
        verify(patientRepository).save(new Patient(PATIENT_UUID, PATIENT_NAME));
        assertEquals(response.getSlotId(), SLOT_UUID);
        assertEquals(response.getMessage(), "Appointment booked successfully.");
    }
}
