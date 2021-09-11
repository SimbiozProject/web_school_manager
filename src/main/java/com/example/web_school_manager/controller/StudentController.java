package com.example.web_school_manager.controller;

import com.example.web_school_manager.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/teacher")
public class StudentController {

    @PostMapping("/loadStudent")
    public Student loadStudent(@RequestBody Student student) {
        student.setName("vova");
        student.setLastName("petra");
        return student;
    }

    @GetMapping("/getStudent")
    public Student getStudent() {
        return new Student("sdsa", "dsjfs");
    }
}
