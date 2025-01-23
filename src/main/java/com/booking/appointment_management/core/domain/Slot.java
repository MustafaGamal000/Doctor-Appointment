package com.booking.appointment_management.core.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Slot {
    private LocalDateTime time;
    private BigDecimal cost;
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
