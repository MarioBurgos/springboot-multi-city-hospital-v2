package com.ironhack.controller.impl;

import com.ironhack.enums.Status;
import com.ironhack.model.Patient;
import com.ironhack.repository.PatientRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PatientControllerImplTest {
@Autowired
    private PatientRepository patientRepository;
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findByDoctorStatus() {
        List<Patient> patients =
        patientRepository.findByAdmittedByStatus(Status.ON);

        System.err.println(patients.toString());
    }
}