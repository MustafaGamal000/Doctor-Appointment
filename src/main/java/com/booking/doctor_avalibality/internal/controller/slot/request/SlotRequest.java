package com.booking.doctor_avalibality.internal.controller.slot.request;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class SlotRequest {
    String doctorName;
    LocalDateTime time;
    BigDecimal cost;

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
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
}
