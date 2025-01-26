package com.booking.doctor_avalibality.internal.controller.mapper;

import com.booking.doctor_avalibality.shared.dtos.DoctorDTO;
import com.booking.doctor_avalibality.internal.entities.DoctorEntity;

import java.util.stream.Collectors;

public class DoctorMapper {
    public static DoctorDTO toDTO(DoctorEntity entity) {
        DoctorDTO dto = new DoctorDTO();
        dto.setDoctorId(entity.getDoctorId());
        dto.setDoctorName(entity.getDoctorName());

        if (entity.getSlots() != null) {
            dto.setSlots(entity.getSlots().stream()
                    .map(SlotMapper::toDTO)
                    .collect(Collectors.toList()));
        }
        return dto;
    }

    public static DoctorEntity toEntity(DoctorDTO dto) {
        DoctorEntity entity = new DoctorEntity();
        entity.setDoctorId(dto.getDoctorId());
        entity.setDoctorName(dto.getDoctorName());
        // Map slots if needed (assuming SlotMapper is available)
        if (dto.getSlots() != null) {
            entity.setSlots(dto.getSlots().stream()
                    .map(SlotMapper::toEntity)
                    .collect(Collectors.toList()));
        }
        return entity;
    }
}
