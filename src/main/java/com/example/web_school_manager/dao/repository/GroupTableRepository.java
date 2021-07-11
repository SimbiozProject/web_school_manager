package com.example.web_school_manager.dao.repository;

import com.example.web_school_manager.bean.GroupTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupTableRepository extends JpaRepository<GroupTable, Long> {
}
