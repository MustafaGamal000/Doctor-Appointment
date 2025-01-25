package com.booking.appointment_management.shell.adapters;

import com.booking.Appointment_booking.shared.dto.AppointmentDTO;
import com.booking.appointment_management.core.domain.Appointment;
import com.booking.appointment_management.core.port.IAppointmentRepository;
import com.booking.Appointment_booking.shared.AppointmentStatus;
import com.booking.appointment_management.shell.mappers.AppointmentMapper;
import com.booking.Appointment_booking.shared.contract.IAppointmentBooking;
import com.booking.doctor_avalibality.shared.contract.IDoctorAvailability;
import com.booking.doctor_avalibality.shared.dtos.DoctorDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class ManagementAppointmentRepository implements IAppointmentRepository {
    private final IAppointmentBooking appointmentBooking;
    private final IDoctorAvailability doctorAvailability;

    public ManagementAppointmentRepository(IAppointmentBooking appointmentBooking, IDoctorAvailability doctorAvailability) {
        this.appointmentBooking = appointmentBooking;
        this.doctorAvailability = doctorAvailability;
    }


    @Override
    public List<Appointment> findAppointmentByDoctorId(UUID doctorId) {
        List<AppointmentDTO> appointments = appointmentBooking.findByDoctorId(doctorId);
        DoctorDTO doctor = doctorAvailability.findDoctorById(doctorId);
        return AppointmentMapper.toDomain(appointments, doctor.getSlots());
    }

    @Override
    public int updateStatusById(UUID appointmentId, AppointmentStatus status) {
        return appointmentBooking.updateStatusById(appointmentId, status);
    }
}
