package com.XMsystem.Questionnaire;

import com.XMsystem.Question.Question;
import com.XMsystem.Test.Test;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Questionnaire implements Serializable {

    @Id
    Integer id;
    Integer durationMin;

    @ManyToMany
    Set<Question> questions = new HashSet<>();

    @ManyToMany
    Set<Test> tests = new HashSet<>();

    public Questionnaire() {
    }

    public Questionnaire(Integer id, Integer duration) {
        this.id = id;
        this.durationMin = duration;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDurationMin() {
        return durationMin;
    }

    public void setDurationMin(Integer durationMin) {
        this.durationMin = durationMin;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }

    public Set<Test> getTests() {
        return tests;
    }

    public void setTests(Set<Test> tests) {
        this.tests = tests;
    }
}
