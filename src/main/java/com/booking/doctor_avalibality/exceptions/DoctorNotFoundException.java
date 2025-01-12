package com.booking.doctor_avalibality.exceptions;

public class DoctorNotFoundException extends RuntimeException {
    public DoctorNotFoundException(String message) {
        super(message);
    }
}
