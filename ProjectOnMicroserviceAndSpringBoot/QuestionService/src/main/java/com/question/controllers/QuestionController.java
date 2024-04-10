package com.question.controllers;

import com.question.entities.Question;
import com.question.services.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    private QuestionService questionService;
    public QuestionController(QuestionService questionService){
        this.questionService=questionService;
    }

    @PostMapping
    public Question createQuestion(@RequestBody Question question){
        return questionService.createQuestion(question);
    }

    @GetMapping
    public List<Question> getAllQuestion(){
        return questionService.getAll();
    }

    @GetMapping("/{id}")
    public Question getQuestion(@PathVariable Long id){
        return questionService.getByQuesID(id);
    }

    @GetMapping("/quiz/{quizId}")
    public List<Question> getQuestionByQuizId(@PathVariable Long quizId){
        return questionService.findByQuizId(quizId);
    }
}
