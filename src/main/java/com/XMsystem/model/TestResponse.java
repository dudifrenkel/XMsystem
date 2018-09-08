package com.XMsystem.Model;


import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TestResponse")
public class TestResponse implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String description;
    private String date;
    @ManyToOne
    @JoinColumn(name="examinee_id")
    private Examinee examinee;

    @JoinTable(name = "test_response_questionnaire_response",
            joinColumns = {@JoinColumn(name = "test_response_id")},
            inverseJoinColumns = {@JoinColumn(name = "questionnaire_response_id")})
    @OneToMany//(mappedBy = "test_response")
    private List<QuestionnaireResponse> questionnaireResponses = new ArrayList<>();

    String notes = "";

    public TestResponse() {
    }

    public TestResponse(String date) {
        this.date = date;
    }

    public void setQnaaireResponse(QuestionnaireResponse qnaaireResponse) {
        this.questionnaireResponses.add(qnaaireResponse);
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Examinee getExaminee() {
        return examinee;
    }

    public void setExaminee(Examinee examinee) {
        this.examinee = examinee;
    }

    public List<QuestionnaireResponse> getQuestionnaireResponses() {
        return questionnaireResponses;
    }

    public void setQuestionnaireResponses(List<QuestionnaireResponse> questionnaireResponses) {
        this.questionnaireResponses = questionnaireResponses;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}

