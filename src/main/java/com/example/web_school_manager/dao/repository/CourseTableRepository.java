package com.example.web_school_manager.dao.repository;

import com.example.web_school_manager.bean.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseTableRepository implements MyJpaRepository<Course, Long> {
}
