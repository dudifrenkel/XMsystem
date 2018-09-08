package com.XMsystem.Dto;

import com.XMsystem.Model.Question;
import com.XMsystem.Model.Questionnaire;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TestDTO implements Serializable {

    Long testId;
    String description;
    List<Questionnaire> questionnaires = new ArrayList<>();
    List<Question> currQuestions;

    public TestDTO() {
    }

    public Long getTestId() {
        return testId;
    }

    public void setTestId(Long testId) {
        this.testId = testId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Questionnaire> getQuestionnaires() {
        return questionnaires;
    }

    public void setQuestionnaires(List<Questionnaire> questionnaires) {
        this.questionnaires = questionnaires;
    }

    public List<Question> getCurrQuestions() {
        return currQuestions;
    }

    public void setCurrQuestions(List<Question> currQuestions) {
        this.currQuestions = currQuestions;
    }
}
