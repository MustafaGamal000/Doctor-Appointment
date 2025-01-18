package com.booking.Appointment_booking.internal.infrastructue.repositories;

import com.booking.Appointment_booking.internal.domain.contract.PatientRepository;
import com.booking.Appointment_booking.internal.domain.models.Patient;
import com.booking.Appointment_booking.internal.infrastructue.mappers.PatientMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class PatientRepositoryImpl implements PatientRepository {
    private final JpaPatientRepository jpaPatientRepository;

    public PatientRepositoryImpl(JpaPatientRepository jpaPatientRepository) {
        this.jpaPatientRepository = jpaPatientRepository;
    }


    @Override
    public Optional<Patient> findById(UUID patientId) {
        return jpaPatientRepository.findById(patientId)
                .map(PatientMapper::toDomain);
    }

    @Override
    public void save(Patient patient) {
        jpaPatientRepository.save(PatientMapper.toEntity(patient));
    }
}
