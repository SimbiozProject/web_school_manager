package com.example.web_school_manager.dao.repository;


import com.example.web_school_manager.bean.QuestionAnswerTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface QuestionAnswerTableRepository extends JpaRepository<QuestionAnswerTable, Long> {

    /*@Query(value = "select id, first_answer, fourth_answer, question, right_answer, second_answer, third_answer  from question_answer", nativeQuery = true)
    List<QuestionAnswerTable> findAllForView();*/

    @Query(value = "SELECT * FROM question_answer WHERE id = ?", nativeQuery = true)
    QuestionAnswerTable findQuestionAnswerTablesById(Long id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE  question_answer " +
            "SET question = ?2, first_answer = ?3, second_answer = ?4, third_answer = ?5, fourth_answer = ?6, " +
            "right_answer = ?7 WHERE question_answer.id = ?1 ", nativeQuery = true)
    void updateDataInTest(Long id, String question, String firstAnswer, String secondAnswer, String thirdAnswer,
                          String fourthAnswer, String rightAnswer);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM question_answer WHERE id = ?1", nativeQuery = true)
    void deleteById(Long id);
}
