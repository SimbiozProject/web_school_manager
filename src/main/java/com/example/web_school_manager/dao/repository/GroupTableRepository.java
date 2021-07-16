package com.example.web_school_manager.dao.repository;

import com.example.web_school_manager.bean.Group;
import org.springframework.stereotype.Repository;

@Repository
public class GroupTableRepository implements MyJpaRepository<Group, Long> {
}
