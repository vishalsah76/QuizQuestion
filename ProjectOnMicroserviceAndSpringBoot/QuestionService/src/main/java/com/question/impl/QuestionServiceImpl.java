package com.question.impl;

import com.question.entities.Question;
import com.question.repositories.QuestionRepository;
import com.question.services.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    private QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository){
        this.questionRepository=questionRepository;
    }

    @Override
    public Question createQuestion(Question ques) {
        return questionRepository.save(ques);
    }

    @Override
    public List<Question> getAll() {
        return questionRepository.findAll();
    }

    @Override
    public Question getByQuesID(Long id) {
        return questionRepository.findById(id).orElseThrow(()->new NullPointerException("No Question FOund"));
    }

    @Override
    public List<Question> findByQuizId(Long quizId) {
        return questionRepository.findByQuizId(quizId);
    }
}
