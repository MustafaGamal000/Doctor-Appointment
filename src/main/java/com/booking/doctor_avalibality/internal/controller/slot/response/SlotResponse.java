package com.booking.doctor_avalibality.internal.controller.slot.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class SlotResponse {

    String message;
    String status;
    BigDecimal cost;
    LocalDateTime time;

    private SlotResponse(String message, String status, BigDecimal cost) {
        this.message = message;
        this.status = status;
        this.cost = cost;
        this.time = LocalDateTime.now();
    }

    public static SlotResponse createSlotResponse(String message,
                                                  String status,
                                                  BigDecimal cost) {
        return new SlotResponse(message, status, cost);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
