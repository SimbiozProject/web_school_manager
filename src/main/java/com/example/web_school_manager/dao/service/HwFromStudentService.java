package com.example.web_school_manager.dao.service;

import com.example.web_school_manager.bean.HwFromStudent;
import com.example.web_school_manager.client.HwFromStudentClient;
import com.example.web_school_manager.dao.repository.HwFromStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HwFromStudentService {

    @Autowired
    HwFromStudentClient hwFromStudentClient;

    @Transactional
    public List<HwFromStudent> findAll() {
        return hwFromStudentClient.findAll();
    }

    @Transactional
    public HwFromStudent findById(Long id) {
        return hwFromStudentClient.findById(id);
    }

    @Transactional
    public List<HwFromStudent> findByFirstName(String firstName) {
        return hwFromStudentClient.findByFirstname(firstName);
    }

    @Transactional
    public List<HwFromStudent> findByLastName(String lastName) {
        return hwFromStudentClient.findByLastname(lastName);
    }

    @Transactional
    public List<HwFromStudent> findByLesson(Integer lesson) {
        return hwFromStudentClient.findByLessonNumber(lesson);
    }

    @Transactional
    public void deleteById(Long id) {
        hwFromStudentClient.deleteById(id);
    }
}


