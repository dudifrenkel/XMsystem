package com.XMsystem.Service;

import com.XMsystem.Model.Answer;
import com.XMsystem.Repository.AnswerRepository;
import com.XMsystem.Repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    public List<Answer> getAllQuestions(){
        List<Answer> questions = new ArrayList<>();
        answerRepository.findAll().forEach(questions::add);
        return questions;
    }

    public void addAnswer (Answer answer){
        answerRepository.save(answer);
    }

    public Answer getQuestion(String id) {
        Optional<Answer> question = answerRepository.findById(Long.valueOf(id));
        if(question.isPresent()){
            return question.get();
        }
        return null;
    }

    public void delete(Answer answer) {
        answerRepository.delete(answer);
    }
}
