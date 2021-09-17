package com.example.web_school_manager.controller;

import com.example.web_school_manager.model.TeacherMenu;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "/")
public class TeacherController {

    @GetMapping(value = "teacher")
    public ModelAndView teacherPage(){
        ModelAndView modelAndView = new ModelAndView("/teacher/home");
        modelAndView.addObject("menuList", getTeacherMenu());
        return modelAndView;
    }

    private List<TeacherMenu> getTeacherMenu() {
        return List.of(
            new TeacherMenu(1, "/test", "Редактировать тест"),
            new TeacherMenu(2, "/uploadHomework", "Загрузить домашнее задание"),
            new TeacherMenu(3, "/downloadHomework", "Получить домашнее задание"),
            new TeacherMenu(4, "/allUsersTest", "Посмотреть результаты тестов"));
    }
}
