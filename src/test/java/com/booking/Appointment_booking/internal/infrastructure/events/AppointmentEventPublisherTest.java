package com.booking.Appointment_booking.internal.infrastructure.events;

import com.booking.Appointment_booking.internal.domain.models.Appointment;
import com.booking.Appointment_booking.internal.domain.models.Patient;
import com.booking.Appointment_booking.internal.infrastructue.events.AppointmentEventPublisher;
import com.booking.Appointment_booking.shared.event.AppointmentCreatedEvent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEventPublisher;

import static com.booking.shared.TestConstants.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AppointmentEventPublisherTest {
    @Mock
    private ApplicationEventPublisher applicationEventPublisher;

    @InjectMocks
    AppointmentEventPublisher appointmentEventPublisher;

    @Test
    void publishAppointmentCreatedEvent_test() {
        // Arrange
        Appointment appointment = new Appointment();
        appointment.setAppointmentId(APPOINTMENT_UUID);
        appointment.setPatient(new Patient(PATIENT_UUID, PATIENT_NAME));
        appointment.setSlotId(SLOT_UUID);
        appointment.setReservedAt(RESERVED_AT);
        appointment.setDoctorId(DOCTOR_UUID);

        AppointmentCreatedEvent expectedAppointmentCreatedEvent = new AppointmentCreatedEvent(
                APPOINTMENT_UUID,
                DOCTOR_UUID,
                SLOT_UUID,
                PATIENT_UUID,
                PATIENT_NAME,
                RESERVED_AT);
        // Act
        appointmentEventPublisher.publishAppointmentCreatedEvent(appointment);

        // Assert
        verify(applicationEventPublisher).publishEvent(expectedAppointmentCreatedEvent);
    }
}
