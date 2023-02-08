package com.ironhack.service.impl;

import com.ironhack.enums.Status;
import com.ironhack.model.Patient;
import com.ironhack.repository.PatientRepository;
import com.ironhack.service.interfaces.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientRepository patientRepository;
    @Override
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }
    @Override
    public Optional<Patient> findById(Long id) {
        return patientRepository.findById(id);
    }
    @Override
    public List<Patient> findByDateOfBirthBetween(String start, String end) {
        return patientRepository.findByDateOfBirthBetween(start, end);
    }
    @Override
    public List<Patient> findByDepartment(String department) {
        return patientRepository.findByDepartment(department);
    }
    @Override
    public List<Patient> findByDoctorStatusOFF() {
        return patientRepository.findByAdmittedByStatus(Status.OFF);
    }
    @Override
    public Patient add(Patient patient) {
        return patientRepository.save(patient);
    }
    @Override
    public void update(Long id, Patient patient) {
        Optional<Patient> optionalPatient = patientRepository.findById(id);
        if(optionalPatient.isPresent()){
            patient.setId(id);
            patientRepository.save(patient);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Patient not found");
        }
    }
}
