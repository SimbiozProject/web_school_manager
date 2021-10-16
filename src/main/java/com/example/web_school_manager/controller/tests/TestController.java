package com.example.web_school_manager.controller.tests;

import com.example.web_school_manager.bean.Test;
import com.example.web_school_manager.client.TestClient;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TestController {
  TestClient testClient;

  @GetMapping("/tests")
  public ModelAndView openTests() {
    ModelAndView mov = new ModelAndView("tests/tests-list");
    mov.addObject("tests", testClient.findAll());
    testClient.findAllPaged();
    return mov;
  }

  @GetMapping("/newtest")
  public ModelAndView openTestsForAdding() {
    ModelAndView mov = new ModelAndView("tests/tests-form");
    return mov;
  }

  @PostMapping("/newtest")
  public String getTestsDataForAdding(@RequestParam String name) {
    String testId = testClient.addTest(name);
    return "redirect:/tests/"+testId;
  }

  @GetMapping("/tests/{id}")
  public ModelAndView openTestById(@PathVariable String id) {
    ModelAndView mov = new ModelAndView("tests/tests-card");
    Test test = testClient.findTestById(id);
    test.setId(id);
    mov.addObject("test", test);
    List<QuestionDto> questions = testClient.findQuestionsByTestId(id);
    mov.addObject("questions", questions);
    return mov;
  }
}
