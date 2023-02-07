package com.ironhack.service.interfaces;

import com.ironhack.model.Patient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PatientService {
    List<Patient> findAll();
    Optional<Patient> findById(Long id);
    List<Patient> findByDateOfBirthBetween(String start, String end);
    List<Patient> findByDepartment(String department);
    List<Patient> findByDoctorStatusOFF();

    Patient add(Patient patient);
    void update(Long id, Patient patient);
}
