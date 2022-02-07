package com.example.studentservice.controller;

import com.example.studentservice.VO.ResponseTemplateVO;
import com.example.studentservice.entity.Student;
import com.example.studentservice.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
@Slf4j

public class StudentsController {

    @Autowired
    StudentService studentService;

    @PostMapping("/")
    public Student saveStudent(@RequestBody Student student) {
        log.info("Inside saveStudent of StudentsController");
        return studentService.saveStudent(student);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getDepartmentWithStudentId(@PathVariable("id") Long studentId) {
        log.info("Inside getDepartmentWithStudentId of StudentsController");
        return studentService.getDepartmentWithStudentId(studentId);
    }
}
