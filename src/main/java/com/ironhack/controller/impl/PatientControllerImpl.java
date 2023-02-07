package com.ironhack.controller.impl;

import com.ironhack.controller.interfaces.PatientController;
import com.ironhack.enums.Status;
import com.ironhack.model.Patient;
import com.ironhack.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PatientControllerImpl implements PatientController {
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/patients")
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    @GetMapping("/patients/{id}")
    public Optional<Patient> findById(@PathVariable Long id) {
        return patientRepository.findById(id);
    }

    @GetMapping("/patients/born-between")
    public List<Patient> findByDateOfBirthBetween(@RequestParam String start, @RequestParam String end) {
        return patientRepository.findByDateOfBirthBetween(start, end);
    }

    @GetMapping("/patients/department/{department}")
    public List<Patient> findByDepartment(@PathVariable String department) {
        return patientRepository.findByDepartment(department);
    }


    @GetMapping("/patients/doctor-status/off")
    public List<Patient> findByDoctorStatusOFF() {
        return patientRepository.findByAdmittedByStatus(Status.OFF);
    }

}
