package com.XMsystem.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ExamineeAnswer")
public class ExamineeAnswer implements Serializable {

    @Id
    @GeneratedValue()
    Long id;

    Long questionId;
    String question;
    String answer;
    boolean isCorrect;

    public ExamineeAnswer() { }

    public ExamineeAnswer(Long questionId, String question, boolean isCorrect) {
        this.questionId = questionId;
        this.question = question;
        this.isCorrect = false;     // false by default
        this.answer = "";   // empty by default
    }

    @ManyToOne
    QuestionnaireResponse questionnaireResponse;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public QuestionnaireResponse getQuestionnaireResponse() {
        return questionnaireResponse;
    }

    public void setQuestionnaireResponse(QuestionnaireResponse questionnaireResponse) {
        this.questionnaireResponse = questionnaireResponse;
    }

}
