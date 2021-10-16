package com.example.web_school_manager.client;

import com.example.web_school_manager.bean.Test;
import com.example.web_school_manager.bean.TgUser;
import com.example.web_school_manager.controller.tests.MyQuestionCollectionModel;
import com.example.web_school_manager.controller.tests.QuestionDto;
import com.example.web_school_manager.model.TestCollection;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

@Component
@RequiredArgsConstructor
public class TestClient {
    protected final ObjectMapper objectMapper;
    @Value("${client.processor}")
    private String uri;
    private final RestTemplate restTemplate;

    private String tests = "/tests";
    private String addQuestion = "/testQuestions";
    private String findQuestionsByTestId = "/testQuestions/search/findAllByTestId";

    public Collection<Test> findAll() {
        var testCollectionResponseEntity =
                restTemplate.getForEntity(String.format("%s%s", uri, tests), TestCollection.class);
        return testCollectionResponseEntity.getBody().getContent();
    }

    public LinkedHashMap findAllPaged() {
       return (LinkedHashMap) restTemplate.getForObject(String.format("%s%s", uri, tests), Object.class);
    }

    public String addTest(String name) {
        Test test = new Test(null, name);

        TypeReference<CollectionModel<Test>> type = new TypeReference<CollectionModel<Test>>() {};
        ResponseEntity<CollectionModel> response = restTemplate.postForEntity(
            String.format("%s%s", uri, tests),
            test,
            CollectionModel.class);
        Link link = (Link) response.getBody().getLink("self").get();

        String testId = link.getHref().substring(link.getHref().lastIndexOf("/")+1);
        return testId;
    }

    public Test findTestById(String id) {
        ResponseEntity<Test> response = restTemplate.getForEntity(
            String.format("%s%s/%s", uri, tests, id),
            Test.class);
        Test test = response.getBody();
        return test;
    }

    public void saveQuestion(QuestionDto questionDto) {
        ResponseEntity<CollectionModel> response = restTemplate.postForEntity(
                String.format("%s%s", uri, addQuestion),
                questionDto,
                CollectionModel.class);
    }

    public List<QuestionDto> findQuestionsByTestId(String testId) {
        ResponseEntity<String> response = restTemplate.getForEntity(
                String.format("%s%s?testId=%s", uri, findQuestionsByTestId, testId),
                String.class);
        String responseBody = response.getBody();
        TypeReference<MyQuestionCollectionModel> type = new TypeReference<>() {};
        MyQuestionCollectionModel model = new MyQuestionCollectionModel();
        try {
            model = objectMapper.readValue(responseBody, type);
        } catch (Exception e) {

        }
        return  model.get_embedded().getTestQuestions();
    }
}
