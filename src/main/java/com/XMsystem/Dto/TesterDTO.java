package com.XMsystem.Dto;

import com.XMsystem.Model.Question;
import com.XMsystem.Model.Questionnaire;
import com.XMsystem.Model.Test;

import java.util.List;

public class TesterDTO {
    String testerName;
    List<Test> Tests;

    public String getTesterName() {
        return testerName;
    }

    public void setTesterName(String testerName) {
        this.testerName = testerName;
    }

    public List<Test> getTests() {
        return Tests;
    }

    public void setTests(List<Test> tests) {
        Tests = tests;
    }
}
