package com.ironhack.controller.impl;

import com.ironhack.controller.interfaces.PatientController;
import com.ironhack.dto.DoctorDepartmentDTO;
import com.ironhack.dto.DoctorStatusDTO;
import com.ironhack.enums.Status;
import com.ironhack.model.Doctor;
import com.ironhack.model.Patient;
import com.ironhack.repository.PatientRepository;
import com.ironhack.service.interfaces.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PatientControllerImpl implements PatientController {
    @Autowired
    private PatientService patientService;
    @GetMapping("/patients")
    public List<Patient> findAll() {
        return patientService.findAll();
    }
    @GetMapping("/patients/{id}")
    public Optional<Patient> findById(@PathVariable Long id) {
        return patientService.findById(id);
    }
    @GetMapping("/patients/born-between")
    public List<Patient> findByDateOfBirthBetween(@RequestParam String start, @RequestParam String end) {
        return patientService.findByDateOfBirthBetween(start, end);
    }
    @GetMapping("/patients/department/{department}")
    public List<Patient> findByDepartment(@PathVariable String department) {
        return patientService.findByDepartment(department);
    }
    @GetMapping("/patients/doctor-status/off")
    public List<Patient> findByDoctorStatusOFF() {
        return patientService.findByDoctorStatusOFF();
    }
    @PostMapping("/patients")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody @Valid Patient patient) { patientService.add(patient); }
    @PutMapping("/patients/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long id, @RequestBody @Valid Patient patient) { patientService.update(id, patient);}
}
