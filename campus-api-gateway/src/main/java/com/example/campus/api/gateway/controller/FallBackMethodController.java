package com.example.campus.api.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {

    @GetMapping("/departmentServiceFallBack")
    public String departmentServiceFallBackMethod()
    {
        return "Department Service is Taking longer than Expected."+
                "Please try again later";
    }

    @GetMapping("/studentServiceFallBack")
    public String studentServiceFallBackMethod()
    {
        return "Student Service is Taking longer than Expected."+
                "Please try again later";
    }


}
