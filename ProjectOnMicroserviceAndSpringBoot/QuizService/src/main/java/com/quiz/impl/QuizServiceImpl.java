package com.quiz.impl;

import com.quiz.entities.Quiz;
import com.quiz.repository.QuizRepository;
import com.quiz.services.QuestionsClient;
import com.quiz.services.QuizService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService {
   private QuizRepository quizRepository;

   private QuestionsClient questionsClient;

    public QuizServiceImpl(QuizRepository quizRepository, QuestionsClient questionsClient) {
        this.quizRepository = quizRepository;
        this.questionsClient = questionsClient;
    }

    @Override
    public Quiz add(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> getAll() {
        //return quizRepository.findAll();
        //Now we will fetch List of questions as well
        List<Quiz> quizzes=quizRepository.findAll();
        List<Quiz> newQuizList=quizzes.stream().map(quiz->{
            quiz.setQuestions(questionsClient.getQuestionOfQuiz(quiz.getId()));
                    return quiz;
        }
        ).collect(Collectors.toList());
        return newQuizList;
    }

    @Override
    public Quiz get(Long id) {
        //return quizRepository.findById(id).orElseThrow(()-> new RuntimeException("Quiz Not Found!!"));
        //Now we will fetch List of questions as well
        Quiz quiz=quizRepository.findById(id).orElseThrow(()->new RuntimeException("Quiz Not Found"));
        quiz.setQuestions(questionsClient.getQuestionOfQuiz(id));
        return quiz;
    }
}
