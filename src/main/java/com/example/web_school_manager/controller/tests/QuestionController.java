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
public class QuestionController {
    TestClient testClient;

    @GetMapping("/tests/{testId}/questions")
    public ModelAndView openQuestionForm(@PathVariable String testId) {
        ModelAndView mov = new ModelAndView("tests/question-form");
        return mov;
    }

    @PostMapping("/tests/{testId}/questions")
    public String openTestById(@PathVariable Long testId,
                                     @RequestParam String question,
                                     @RequestParam String answer1,
                                     @RequestParam String answer2,
                                     @RequestParam String answer3,
                                     @RequestParam String answer4,
                                     @RequestParam(value = "answer1IsTrue", required = false) Boolean answer1IsTrue,
                                     @RequestParam(value = "answer2IsTrue", required = false) Boolean answer2IsTrue,
                                     @RequestParam(value = "answer3IsTrue", required = false) Boolean answer3IsTrue,
                                     @RequestParam(value = "answer4IsTrue", required = false) Boolean answer4IsTrue) {

        List<QuestionDto.Answer> answers = List.of (
                new QuestionDto.Answer(answer1, answer1IsTrue),
                new QuestionDto.Answer(answer2, answer2IsTrue),
                new QuestionDto.Answer(answer3, answer3IsTrue),
                new QuestionDto.Answer(answer4, answer4IsTrue));

        QuestionDto questionDto = new QuestionDto();
        questionDto.setQuestion(question);
        questionDto.setAnswerList(answers);
        questionDto.setTestId(testId);
        testClient.saveQuestion(questionDto);

        return "redirect:/tests/"+testId;
    }
}
