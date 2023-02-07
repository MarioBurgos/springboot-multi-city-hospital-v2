package com.ironhack.controller.interfaces;

import com.ironhack.dto.DoctorDepartmentDTO;
import com.ironhack.dto.DoctorStatusDTO;
import com.ironhack.enums.Status;
import com.ironhack.model.Doctor;
import com.ironhack.model.Patient;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface PatientController {

    List<Patient> findAll();
    Optional<Patient> findById(Long id);
    List<Patient> findByDateOfBirthBetween(String start, String end);
    List<Patient> findByDepartment(String department);
    List<Patient> findByDoctorStatusOFF();
    void add(Patient patient);
    void update(Long id, Patient patient);
}
