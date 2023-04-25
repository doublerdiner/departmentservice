package com.codeclan.departmentservice.controllers;

import com.codeclan.departmentservice.models.Department;
import com.codeclan.departmentservice.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
@RestController
public class DepartmentController {
        @Autowired
        private DepartmentRepository departmentRepository;
        @GetMapping(value = "/departments")
        public List<Department> getAllDepartments() {
            return departmentRepository.findAll();
        }

        @GetMapping(value = "/departments/{id}")
        public Optional<Department> getDepartment(@PathVariable Long id) {
            return departmentRepository.findById(id);
        }
    }
