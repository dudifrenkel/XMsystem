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

    private final AnswerRepository answerRepository;

    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    //    public List<Answer> getAllQuestions(){
//        List<Answer> questions = new ArrayList<>();
//        answerRepository.findAll().forEach(questions::add);
//        return questions;
//    }

    public void addAnswer (Answer answer){
        answerRepository.save(answer);
    }

    public Answer getAnswer(String id) {
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
