package com.example.web_school_manager.dao.service;

import com.example.web_school_manager.bean.HwFromStudentTable;
import com.example.web_school_manager.dao.repository.HwFromStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HwFromStudentService {

    @Autowired
    HwFromStudentRepository hwFromStudentRepository;

    @Transactional
    public List<HwFromStudentTable> findAll() {
        return hwFromStudentRepository.findAll();
    }

    @Transactional
    public HwFromStudentTable findById(Long id) {
        return hwFromStudentRepository.findHwFromStudentTableByStudentId(id);
    }

    @Transactional
    public List<HwFromStudentTable> findByFirstName(String firstName) {
        return hwFromStudentRepository.findHwFromStudentTablesByStudentName_FirstNameContains(firstName);
    }

    @Transactional
    public List<HwFromStudentTable> findByLastName(String lastName) {
        return hwFromStudentRepository.findHwFromStudentTablesByStudentNameLastNameContains(lastName);
    }

    @Transactional
    public List<HwFromStudentTable> findByLesson(Integer lesson) {
        return hwFromStudentRepository.findHwFromStudentTablesByLessonNumber(lesson);
    }

    @Transactional
    public void deleteById(Long id) {
        hwFromStudentRepository.deleteById(id);
    }

}


