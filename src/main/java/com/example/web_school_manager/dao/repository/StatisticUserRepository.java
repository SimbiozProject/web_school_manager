package com.example.web_school_manager.dao.repository;

import com.example.web_school_manager.bean.StatisticUser;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class StatisticUserRepository implements MyJpaRepository<StatisticUser, Long> {

    public List<StatisticUser> findAllByActiveTrue(){
        return null;
    }
}
