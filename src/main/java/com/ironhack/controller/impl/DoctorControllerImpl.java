package com.ironhack.controller.impl;

import com.ironhack.controller.interfaces.DoctorController;
import com.ironhack.dto.DoctorDepartmentDTO;
import com.ironhack.dto.DoctorStatusDTO;
import com.ironhack.enums.Department;
import com.ironhack.model.Doctor;
import com.ironhack.enums.Status;
import com.ironhack.repository.DoctorRepository;
import com.ironhack.service.interfaces.DoctorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DoctorControllerImpl implements DoctorController {
    @Autowired
    private DoctorService doctorService;
    @GetMapping("/doctors")
    public List<Doctor> findAll() {
        return doctorService.findAll();
    }
    @GetMapping("/doctors/{id}")
    public Optional<Doctor> findById(@PathVariable(name = "id") Long id) {
        return doctorService.findById(id);
    }
    @GetMapping("/doctors/status/{status}")
    public List<Doctor> findByStatus(@PathVariable Status status) {
        return doctorService.findByStatus(status);
    }
    @GetMapping("/doctors/department/{department}")
    public List<Doctor> findByDepartment(@PathVariable Department department) {
        return doctorService.findByDepartment(department);
    }
    @PostMapping("/doctors")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody @Valid Doctor doctor) {
        doctorService.add(doctor);
    }
    @PatchMapping("/doctors/{id}/status")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateStatus(@PathVariable Long id, @RequestBody DoctorStatusDTO doctor) {
        doctorService.updateStatus(id, doctor);
    }
    @PatchMapping("/doctors/{id}/department")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateDepartment(@PathVariable Long id, @RequestBody DoctorDepartmentDTO doctor) {
        doctorService.updateDepartment(id, doctor);
    }

}
