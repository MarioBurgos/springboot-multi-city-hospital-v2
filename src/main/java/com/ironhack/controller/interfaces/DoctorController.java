package com.ironhack.controller.interfaces;

import com.ironhack.model.Doctor;
import com.ironhack.enums.Status;

import java.util.List;
import java.util.Optional;

public interface DoctorController {
    List<Doctor> findAll();
    Optional<Doctor> findById(Long id);
    List<Doctor> findByStatus(Status status);
    List<Doctor> findByDepartment(String department);

}
