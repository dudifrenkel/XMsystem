package com.XMsystem.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Questionnaire")
public class Questionnaire implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String description;
    private Integer durationMin;

    @ManyToMany()
    @JoinTable(
            name = "questionnaire_question",
            joinColumns = {@JoinColumn(name = "questionnaire_id")},
            inverseJoinColumns = {@JoinColumn(name = "question_id")}
    )
    private List<Question> questions = new ArrayList<>();

    @ManyToMany(mappedBy = "questionnaires")
    private List<Test> tests = new ArrayList<>();

    public Questionnaire() {
    }

    public Questionnaire(String description, Integer durationMin) {
        this.description = description;
        this.durationMin = durationMin;
    }

    public Questionnaire(Integer duration) {
        this.durationMin = duration;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDurationMin() {
        return durationMin;
    }

    public void setDurationMin(Integer durationMin) {
        this.durationMin = durationMin;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<Test> getTests() {
        return tests;
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
    }

    @PreRemove
    private void removeQuestionnaireFromTests() {
        for (Test test : tests) {
            test.getQuestionnaires().remove(this);
        }
    }
}
