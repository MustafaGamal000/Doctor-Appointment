package com.booking.shared;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

public class TestConstants {
    public static final UUID SLOT_UUID = UUID.fromString("fd08fc44-f154-4d53-b444-736d3f114dd2");
    public static final UUID PATIENT_UUID = UUID.fromString("98e2e794-5e46-4a25-9f5f-6bcab3660ce4");
    public static final UUID DOCTOR_UUID = UUID.fromString("3f005c67-0abe-4bc3-b15e-0bb0c6dc8089");
    public static final UUID APPOINTMENT_UUID = UUID.fromString("ca6e9e82-638e-4cf2-a553-6d77157109af");
    public static final String PATIENT_NAME = "Patient Name";
    public static final String DOCTOR_NAME = "Doctor Name";
    public static final LocalDateTime RESERVED_AT = LocalDateTime.ofEpochSecond(1737917503, 0, ZoneOffset.UTC);
}
