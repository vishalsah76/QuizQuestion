package com.question.services;

import com.question.entities.Question;

import java.util.List;

public interface QuestionService {

    Question createQuestion(Question ques);
    List<Question> getAll();
    Question getByQuesID(Long id);

    List<Question> findByQuizId(Long quizId);
}
