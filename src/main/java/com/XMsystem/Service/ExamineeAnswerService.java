package com.XMsystem.Service;

import com.XMsystem.Model.ExamineeAnswer;
import com.XMsystem.Repository.ExamineeAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class ExamineeAnswerService {

    @Autowired
    private ExamineeAnswerRepository examineeAnswerRepository;

//    public List<Answer> getAllQuestions(){
//        List<Answer> questions = new ArrayList<>();
//        answerRepository.findAll().forEach(questions::add);
//        return questions;
//    }

    public void addExamineeAnswer (ExamineeAnswer answer){
        examineeAnswerRepository.save(answer);
    }

    public void addExamineeAnswer (Map<Long,ExamineeAnswer> answers){
        for (Map.Entry<Long,ExamineeAnswer> examineeAnswer : answers.entrySet()) {
            addExamineeAnswer(examineeAnswer.getValue());
        }
    }
//    public Answer getQuestion(String id) {
//        Optional<Answer> question = answerRepository.findById(Long.valueOf(id));
//        if(question.isPresent()){
//            return question.get();
//        }
//        return null;
//    }
//
//    public void delete(Answer answer) {
//        answerRepository.delete(answer);
//    }
}
