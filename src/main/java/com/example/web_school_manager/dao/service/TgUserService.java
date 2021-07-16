package com.example.web_school_manager.dao.service;

import com.example.web_school_manager.bean.TgUser;
import com.example.web_school_manager.dao.repository.TgUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TgUserService {

    @Autowired
    private TgUserRepository tgUserRepository;

    @Transactional
    public Iterable<TgUser> findAll() {
        return tgUserRepository.findAll();
    }

    @Transactional
    public Optional<TgUser> findById(Long id) {
        return tgUserRepository.findById(id);
    }

    @Transactional
    public Optional<TgUser> findByUserName(String userName) {
        return tgUserRepository.findByUserName(userName);
    }

    @Transactional
    public Optional<TgUser> findByFirstName(String firstName) {
        return tgUserRepository.findByFirstName(firstName);
    }

    @Transactional
    public Optional<TgUser> findByLastName(String lastName) {
        return tgUserRepository.findByLastName(lastName);
    }

    @Transactional
    public TgUser findByEmail(String email) {
        return tgUserRepository.findByEmail(email);
    }

    @Transactional
    public void deleteById(Long id) {
        tgUserRepository.deleteById(id);
    }

    @Transactional
    public void deleteAll() {
        tgUserRepository.deleteAll();
    }

    @Transactional
    public Long countAll() {
        return tgUserRepository.count();
    }

}
