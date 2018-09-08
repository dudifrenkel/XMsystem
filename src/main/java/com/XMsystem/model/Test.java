package com.XMsystem.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "Test")
public class Test implements Serializable {

    @Id
    @GeneratedValue()
    Long id;
    String description;

    @ManyToMany()
    @JoinTable(
            name = "Test_Questionnaire",
            joinColumns = {@JoinColumn(name = "test_id")},
            inverseJoinColumns = {@JoinColumn(name = "questionnaire_id")}
    )
    List<Questionnaire> questionnaires = new ArrayList<>();

    @ManyToMany(mappedBy = "tests" )
    List<Tester> testers = new ArrayList<>();

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

    public List<Tester> getTesters() {
        return testers;
    }

    public void setTesters(List<Tester> testers) {
        this.testers = testers;
    }

    public void addQuestionnaires(Questionnaire q){
        this.questionnaires.add(q);
    }

    public void removeQuestionnaires(Long id){
        this.questionnaires.removeIf(questionnaire -> questionnaire.getId()==id);
    }

    public void addTester(Tester tester){
        this.testers.add(tester);
    }

    public List<String> getQnnaireIds(){
        List<String> qnnaireIds = new ArrayList<>();
        for (Questionnaire qnnaire:this.questionnaires) {
            qnnaireIds.add(qnnaire.getId().toString());
        }
        return qnnaireIds;
    }

    @PreRemove
    private void removeTestFromTesters() {
        for (Tester tester : testers) {
            tester.getTests().remove(this);
        }
    }
}
