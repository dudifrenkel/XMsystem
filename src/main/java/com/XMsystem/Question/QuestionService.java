package com.XMsystem.Question;

import com.XMsystem.Examinee.Examinee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> getAllQuestions(){
        List<Question> questions = new ArrayList<>();
        questionRepository.findAll().forEach(questions::add);
        return questions;
    }

    public void addQuestion (Question question){
        questionRepository.save(question);
    }

    public Question getQuestion(String id) {
        Optional<Question> question = questionRepository.findById(Integer.valueOf(id));
        if(question.isPresent()){
            return question.get();
        }
        return null;
    }

}