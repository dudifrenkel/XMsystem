package com.XMsystem.Service;

import com.XMsystem.Model.ExamineeAnswer;
import com.XMsystem.Repository.ExamineeAnswerRepository;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class ExamineeAnswerService {

    private final ExamineeAnswerRepository examineeAnswerRepository;

    public ExamineeAnswerService(ExamineeAnswerRepository examineeAnswerRepository) {
        this.examineeAnswerRepository = examineeAnswerRepository;
    }

    public void addExamineeAnswers(ExamineeAnswer answer){
        examineeAnswerRepository.save(answer);
    }

    public void addExamineeAnswers(Map<Long,ExamineeAnswer> answers){
        for (Map.Entry<Long,ExamineeAnswer> examineeAnswer : answers.entrySet()) {
            addExamineeAnswers(examineeAnswer.getValue());
        }
    }

}
