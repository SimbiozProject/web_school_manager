package com.example.web_school_manager.dao.service;

import com.example.web_school_manager.bean.TgUser;
import com.example.web_school_manager.dao.repository.TgUserTableDaoWebRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TgUserTableDaoWebService {

    @Autowired
    private TgUserTableDaoWebRepository tgUserTableDaoWebRepository;

    @Transactional
    public Iterable<TgUser> findAll() {
        return tgUserTableDaoWebRepository.findAll();
    }

    @Transactional
    public Optional<TgUser> findById(Long id) {
        return tgUserTableDaoWebRepository.findById(id);
    }

    @Transactional
    public Optional<TgUser> findByUserName(String userName) {
        return tgUserTableDaoWebRepository.findByUserName(userName);
    }

    @Transactional
    public Optional<TgUser> findByFirstName(String firstName) {
        return tgUserTableDaoWebRepository.findByFirstName(firstName);
    }

    @Transactional
    public Optional<TgUser> findByLastName(String lastName) {
        return tgUserTableDaoWebRepository.findByLastName(lastName);
    }

    @Transactional
    public TgUser findByEmail(String email) {
        return tgUserTableDaoWebRepository.findByEmail(email);
    }

    @Transactional
    public void deleteById(Long id) {
        tgUserTableDaoWebRepository.deleteById(id);
    }

    @Transactional
    public void deleteAll() {
        tgUserTableDaoWebRepository.deleteAll();
    }

    @Transactional
    public Long countAll() {
        return tgUserTableDaoWebRepository.count();
    }

}
