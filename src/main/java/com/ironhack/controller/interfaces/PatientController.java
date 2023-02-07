package com.ironhack.controller.interfaces;

import com.ironhack.enums.Status;
import com.ironhack.model.Patient;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface PatientController {

    List<Patient> findAll();
    Optional<Patient> findById(Long id);
    List<Patient> findByDateOfBirthBetween(String start, String end);
    List<Patient> findByDepartment(String department);
    List<Patient> findByDoctorStatusOFF();



}
