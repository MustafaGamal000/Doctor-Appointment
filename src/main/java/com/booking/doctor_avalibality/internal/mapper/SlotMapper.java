package com.booking.doctor_avalibality.internal.mapper;

import com.booking.doctor_avalibality.shared.dtos.SlotDTO;
import com.booking.doctor_avalibality.internal.entities.DoctorEntity;
import com.booking.doctor_avalibality.internal.entities.SlotEntity;

public class SlotMapper {
    public static SlotDTO toDTO(SlotEntity entity) {
        SlotDTO dto = new SlotDTO();
        dto.setSlotId(entity.getSlotId());
        dto.setTime(entity.getTime());
        dto.setReserved(entity.isReserved());
        dto.setReservedAt(entity.getReservedAt());
        dto.setCost(entity.getCost());

        if (entity.getDoctor() != null) {
            dto.setDoctorId(entity.getDoctor().getDoctorId());
        }
        return dto;
    }

    public static SlotEntity toEntity(SlotDTO dto) {
        SlotEntity entity = new SlotEntity();
        entity.setSlotId(dto.getSlotId());
        entity.setTime(dto.getTime());
        entity.setReserved(dto.isReserved());
        entity.setReservedAt(dto.getReservedAt());
        entity.setCost(dto.getCost());

        if (dto.getDoctorId() != null) {
            DoctorEntity doctorEntity = new DoctorEntity();
            doctorEntity.setDoctorId(dto.getDoctorId());
            entity.setDoctor(doctorEntity);
        }

        return entity;
    }
}
