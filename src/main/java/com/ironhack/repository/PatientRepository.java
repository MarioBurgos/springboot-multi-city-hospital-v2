package com.ironhack.repository;

import com.ironhack.enums.Status;
import com.ironhack.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    List<Patient> findByDateOfBirthBetween(String start, String end);
    @Query("SELECT p FROM Patient p JOIN p.admittedBy WHERE department = :dept ")
    List<Patient> findByDepartment(@Param("dept") String department);
//    @Query("SELECT p FROM Patient p JOIN p.admittedBy WHERE status = :status ")
    List<Patient> findByAdmittedByStatus(Status status);
}
