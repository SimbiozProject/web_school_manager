package com.example.web_school_manager.dao.repository;

import com.example.web_school_manager.bean.UserAnswerTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAnswerRepository extends JpaRepository<UserAnswerTable, Long> {

    UserAnswerTable findByUserName(String userName);
}
