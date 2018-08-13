package com.XMsystem.Question;

import com.XMsystem.Answer.Answer;
import com.XMsystem.Questionnaire.Questionnaire;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Question implements Serializable {

    @Id
    Integer id;

    String body;

    @OneToMany
    Set<Answer> answers = new HashSet<>();

    @ManyToMany
    Set<Questionnaire> questionnaires = new HashSet<>();

    public Question() {}

    public Question(Integer id, String body, Answer answer) {
        super();
        this.id = id;
        this.body = body;
//        this.answer = answer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Set<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<Answer> answers) {
        this.answers = answers;
    }

    public Set<Questionnaire> getQuestionnaires() {
        return questionnaires;
    }

    public void setQuestionnaires(Set<Questionnaire> questionnaires) {
        this.questionnaires = questionnaires;
    }
}
