package com.XMsystem.Answer;

import com.XMsystem.Question.Question;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.io.Serializable;

@Entity
public class Answer implements Serializable {

    @Id
    Integer id;
    String content;
    boolean isTrue;

    @ManyToOne
    Question question;

    public Answer(Integer id, String content, boolean isTrue, Question question) {
        this.id = id;
        this.content = content;
        this.isTrue = isTrue;
        this.question = question;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isTrue() {
        return isTrue;
    }

    public void setTrue(boolean aTrue) {
        isTrue = aTrue;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
