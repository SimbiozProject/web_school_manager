package com.example.web_school_manager.dao.repository;

import com.example.web_school_manager.bean.HwFromStudentTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HwForStudentRepository extends JpaRepository<HwFromStudentTable, Long> {
}
