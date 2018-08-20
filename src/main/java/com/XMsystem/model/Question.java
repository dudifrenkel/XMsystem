package com.XMsystem.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Question")
public class Question implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    Long id;
    String body;

//    Answer correctAns;

    @OneToMany(mappedBy = "question")
    List<Answer> answers = new ArrayList<>();

    @ManyToMany(mappedBy = "questions")
    Set<Questionnaire> questionnaires = new HashSet<>();

    public Question() {}

    public Question(String body) {
        super();
        this.body = body;
    }

    public Long getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

//    public Answer getCorrectAns() {
//        return correctAns;
//    }
//
//    public void setCorrectAns(Answer correctAns) {
//        this.correctAns = correctAns;
//    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public Set<Questionnaire> getQuestionnaires() {
        return questionnaires;
    }

    public void setQuestionnaires(Set<Questionnaire> questionnaires) {
        this.questionnaires = questionnaires;
    }

    public void addAnswer (Answer ans){
        this.answers.add(ans);
    }
}
