package com.ironhack.service.impl;

import com.ironhack.dto.DoctorDepartmentDTO;
import com.ironhack.dto.DoctorStatusDTO;
import com.ironhack.enums.Department;
import com.ironhack.enums.Status;
import com.ironhack.model.Doctor;
import com.ironhack.repository.DoctorRepository;
import com.ironhack.service.interfaces.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;
    @Override
    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }
    @Override
    public Optional<Doctor> findById(Long id) {
        return doctorRepository.findById(id);
    }
    @Override
    public List<Doctor> findByStatus(Status status) {
        return doctorRepository.findByStatus(status);
    }
    @Override
    public List<Doctor> findByDepartment(Department department) {
        return doctorRepository.findByDepartment(department);
    }
    @Override
    public Doctor add(Doctor doctor) {
        return doctorRepository.save(doctor);
    }
    @Override
    public void updateStatus(Long id, DoctorStatusDTO doctor) {

    }
    @Override
    public void updateDepartment(Long id, DoctorDepartmentDTO doctor) {

    }
}
