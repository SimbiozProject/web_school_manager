package com.example.web_school_manager.dao.service;

import com.example.web_school_manager.bean.HwFromStudent;
import com.example.web_school_manager.dao.repository.HwFromStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HwFromStudentService {

    /*@Autowired
    HwFromStudentRepository hwFromStudentRepository;

    @Transactional
    public List<HwFromStudent> findAll() {
        return hwFromStudentRepository.findAll();
    }

    @Transactional
    public HwFromStudent findById(Long id) {
        return hwFromStudentRepository.findHwFromStudentByStudentId(id);
    }

    @Transactional
    public List<HwFromStudent> findByFirstName(String firstName) {
        return hwFromStudentRepository.findHwFromStudentByStudentName_FirstNameContains(firstName);
    }

    @Transactional
    public List<HwFromStudent> findByLastName(String lastName) {
        return hwFromStudentRepository.findHwFromStudentTablesByStudentNameLastNameContains(lastName);
    }

    @Transactional
    public List<HwFromStudent> findByLesson(Integer lesson) {
        return hwFromStudentRepository.findHwFromStudentByLessonNumber(lesson);
    }

    @Transactional
    public void deleteById(Long id) {
        hwFromStudentRepository.deleteById(id);
    }*/

}


