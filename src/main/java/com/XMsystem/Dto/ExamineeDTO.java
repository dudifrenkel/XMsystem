package com.XMsystem.Dto;

import com.XMsystem.Model.Question;
import com.XMsystem.Model.Questionnaire;
import com.XMsystem.Model.Test;

import java.time.LocalDateTime;

public class ExamineeDTO  {
    private Long examineeId;
    private String examineeName;
    private Test currTest;
    private Questionnaire currQuestionnaire;
    private LocalDateTime currQuestionnireStartTime;

    public String getExamineeName() {
        return examineeName;
    }

    public void setExamineeName(String examineeName) {
        this.examineeName = examineeName;
    }

    public Test getCurrTest() {
        return currTest;
    }

    public void setCurrTest(Test currTest) {
        this.currTest = currTest;
    }

    public Questionnaire getCurrQuestionnaire() {
        return currQuestionnaire;
    }

    public void setCurrQuestionnaire(Questionnaire currQuestionnaire) {
        this.currQuestionnaire = currQuestionnaire;
    }

    public LocalDateTime getCurrQuestionnireStartTime() {
        return currQuestionnireStartTime;
    }

    public void setCurrQuestionnireStartTime(LocalDateTime currQuestionnireStartTime) {
        this.currQuestionnireStartTime = currQuestionnireStartTime;
    }
}
