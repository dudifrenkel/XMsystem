package com.XMsystem.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Answer")
public class Answer implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String content;
    private boolean isCorrect;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    public Answer(){}

    public Answer(String content, boolean isCorrect) {
        super();
        this.content = content;
        this.isCorrect = isCorrect;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
