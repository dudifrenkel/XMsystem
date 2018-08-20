package com.XMsystem.Service;

import com.XMsystem.Model.Questionnaire;
import com.XMsystem.Repository.QuestionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionnaireService {

    @Autowired
    private QuestionnaireRepository questionRepository;

    public List<Questionnaire> getAllQuestions(){
        List<Questionnaire> questions = new ArrayList<>();
        questionRepository.findAll().forEach(questions::add);
        return questions;
    }

    public void addQuestion (Questionnaire question){
        questionRepository.save(question);
    }

    public Questionnaire getQuestion(String id) {
        Optional<Questionnaire> question = questionRepository.findById(Long.valueOf(id));
        if(question.isPresent()){
            return question.get();
        }
        return null;
    }

}
