package com.XMsystem.Service;


import com.XMsystem.Model.QuestionnaireResponse;
import com.XMsystem.Repository.QuestionnaireResponseRepository;
import org.springframework.stereotype.Service;



@Service
public class QuestionnaireResponseService {

    private final QuestionnaireResponseRepository questionnaireResponseRepository;

    public QuestionnaireResponseService(QuestionnaireResponseRepository questionnaireResponseRepository) {
        this.questionnaireResponseRepository = questionnaireResponseRepository;
    }

    public void addQuestionnaireResponse(QuestionnaireResponse questionnaireResponse) {
        questionnaireResponseRepository.save(questionnaireResponse);
    }

}
