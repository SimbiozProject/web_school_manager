package com.example.web_school_manager.dao.repository;

import com.example.web_school_manager.bean.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseRepository implements MyJpaRepository<Course, Long> {
}
