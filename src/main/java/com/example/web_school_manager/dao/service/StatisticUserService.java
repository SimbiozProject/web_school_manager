package com.example.web_school_manager.dao.service;

import com.example.web_school_manager.bean.StatisticUser;

import java.util.List;
import java.util.Optional;

public interface StatisticUserService {
    void save(StatisticUser statisticUser);

    List<StatisticUser> retrieveAllActiveUsers();

    Optional<StatisticUser> findByChatId(Long chatId);
}
