package com.XMsystem.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Questionnaire")
public class Questionnaire implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String description;
    private Integer durationMin;

    @ManyToMany(/*cascade = {CascadeType.ALL*}*/)
    @JoinTable(
            name = "Questionnaire_Question",
            joinColumns = {@JoinColumn(name = "questionnaire_id")},
            inverseJoinColumns = {@JoinColumn(name = "question_id")}
    )
    private List<Question> questions = new ArrayList<>();

    @ManyToMany(mappedBy = "questionnaires")
    private Set<Test> tests = new HashSet<>();

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

    public Set<Test> getTests() {
        return tests;
    }

    public void setTests(Set<Test> tests) {
        this.tests = tests;
    }

    public void addQuestion(Question question){
        this.questions.add(question);
    }

    public void removeQuestion(Long id){
        questions.removeIf(question -> question.getId()==id);
    }
}
