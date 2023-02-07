package com.ironhack.repository;

import com.ironhack.enums.Department;
import com.ironhack.model.Doctor;
import com.ironhack.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    List<Doctor> findByStatus(Status status);
    List<Doctor> findByDepartment(Department department);
}
