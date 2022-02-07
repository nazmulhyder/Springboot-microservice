package com.example.department.controller;

import com.example.department.entity.Department;
import com.example.department.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
@Slf4j

public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department department)
    {
        log.info("Inside saveDepartment method of DepartmentController");
        return this.departmentService.saveDepartment(department);
    }

    @GetMapping("/{id}")
    public Department findByDepartmentId(@PathVariable("id") Long id)
    {
        log.info("Inside getDepartment method of DepartmentController");
        return this.departmentService.findByDepartmentId(id);
    }

}
