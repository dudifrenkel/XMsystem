package com.XMsystem.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "Test")
public class Test implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    Long id;
    String description;

    @ManyToMany(/*cascade = {CascadeType.ALL}*/)
    @JoinTable(
            name = "Test_Questionnaire",
            joinColumns = {@JoinColumn(name = "test_id")},
            inverseJoinColumns = {@JoinColumn(name = "questionnaire_id")}
    )
    List<Questionnaire> questionnaires = new ArrayList<>();

//    @ManyToMany
//    List<Tester> testers = new ArrayList<>();

    public Test() { }

    public Test(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Questionnaire> getQuestionnaires() {
        return questionnaires;
    }

    public void setQuestionnaires(List<Questionnaire> questionnaires) {
        this.questionnaires = questionnaires;
    }

//    public List<Tester> getActiveOnTesters() {
//        return testers;
//    }
//
//    public void setTesters(List<Tester> testers) {
//        this.testers = testers;
//    }

    public void addQuestionnaires(Questionnaire q){
        this.questionnaires.add(q);
    }

    public void removeQuestionnaires(Long id){
        this.questionnaires.removeIf(questionnaire -> questionnaire.getId()==id);
    }
}
