package com.example.studentservice.repository;

import com.example.studentservice.entity.Student;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository  extends JpaRepository<Student,Long> {

    Student findByStudentId(Long id);
}
