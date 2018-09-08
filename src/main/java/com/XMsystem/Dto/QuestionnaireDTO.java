package com.XMsystem.Dto;

import com.XMsystem.Model.Question;
import com.XMsystem.Model.Questionnaire;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class QuestionnaireDTO implements Serializable {

    Long questionnairesId;
    String description;
    List<Question> currQuestions;

    public QuestionnaireDTO() {
    }

    public Long getQuestionnairesId() {
        return questionnairesId;
    }

    public void setQuestionnairesId(Long questionnairesId) {
        this.questionnairesId = questionnairesId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Question> getCurrQuestions() {
        return currQuestions;
    }

    public void setCurrQuestions(List<Question> currQuestions) {
        this.currQuestions = currQuestions;
    }
}
