package com.booking.appointment_management.shell.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class ManagementSlotDTO {
    private LocalDateTime time;
    private BigDecimal cost;
    private List<ManagementAppointmentDTO> appointments;

    public ManagementSlotDTO(LocalDateTime time, BigDecimal cost, List<ManagementAppointmentDTO> appointments) {
        this.time = time;
        this.cost = cost;
        this.appointments = appointments;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public List<ManagementAppointmentDTO> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<ManagementAppointmentDTO> appointments) {
        this.appointments = appointments;
    }
}
