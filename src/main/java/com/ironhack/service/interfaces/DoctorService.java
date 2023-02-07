package com.ironhack.service.interfaces;

import com.ironhack.dto.DoctorDepartmentDTO;
import com.ironhack.dto.DoctorStatusDTO;
import com.ironhack.enums.Department;
import com.ironhack.enums.Status;
import com.ironhack.model.Doctor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface DoctorService {

    List<Doctor> findAll();
    Optional<Doctor> findById(Long id);
    List<Doctor> findByStatus(Status status);
    List<Doctor> findByDepartment(Department department);
    Doctor add(Doctor doctor);
    void updateStatus(Long id, DoctorStatusDTO doctor);
    void updateDepartment(Long id, DoctorDepartmentDTO doctor);


}
