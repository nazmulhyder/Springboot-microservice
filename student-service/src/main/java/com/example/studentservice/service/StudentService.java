package com.example.studentservice.service;

import com.example.studentservice.VO.Department;
import com.example.studentservice.VO.ResponseTemplateVO;
import com.example.studentservice.entity.Student;
import com.example.studentservice.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j

public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Student saveStudent(Student student) {
        log.info("Inside saveStudent of StudentService");
        return studentRepository.save(student);
    }

    public ResponseTemplateVO getDepartmentWithStudentId(Long studentId) {
        ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();
        Student student = studentRepository.findByStudentId(studentId);
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + student.getStudentId(),Department.class);

        responseTemplateVO.setStudent(student);
        responseTemplateVO.setDepartment(department);

        return responseTemplateVO;
    }
}
