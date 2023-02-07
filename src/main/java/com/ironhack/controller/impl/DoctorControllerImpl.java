package com.ironhack.controller.impl;

import com.ironhack.controller.interfaces.DoctorController;
import com.ironhack.model.Doctor;
import com.ironhack.enums.Status;
import com.ironhack.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
@RestController
public class DoctorControllerImpl implements DoctorController {
    @Autowired
    private DoctorRepository doctorRepository;

    @GetMapping("/doctors")
    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }

    @GetMapping("/doctors/{id}")
    public Optional<Doctor> findById(@PathVariable(name = "id") Long id) {
        return doctorRepository.findById(id);
    }

    @GetMapping("/doctors/status/{status}")
    public List<Doctor> findByStatus(@PathVariable Status status) {
        return doctorRepository.findByStatus(status);
    }

    @GetMapping("/doctors/department/{department}")
    public List<Doctor> findByDepartment(@PathVariable String department) {
        return doctorRepository.findByDepartment(department);
    }
}
