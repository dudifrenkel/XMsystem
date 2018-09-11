package com.XMsystem.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Examinee implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull()
    @Size(min = 8, max = 9, message = "יש להכניס בין 8 ל-9 ספרות")
    private String taz;
    @NotNull()
    @Size(min = 1, message = "שדה חובה")
    private String firstName;
    @NotNull()
    @Size(min = 1, message = "שדה חובה")
    private String lastName;
    @NotNull()
    @Size(min = 1, message = "שדה חובה")
    private String birthDate;
    private Character sex;
    @ManyToOne(fetch = FetchType.EAGER)
    private Tester currTester;
    @OneToOne
    private Test currTest;
    @OneToMany(mappedBy = "examinee")
    List<TestResponse> testResponses = new ArrayList<>();

    public Examinee(){ }

    public Examinee(String taz, String firstName, String lastName, String dateOfBirth, Character gender) {
        super();
        this.taz = taz;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = dateOfBirth;
        this.sex = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaz() {
        return taz;
    }

    public void setTaz(String taz) {
        this.taz = taz;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Character getSex() {
        return sex;
    }

    public void setSex(Character sex) {
        this.sex = sex;
    }

    public Tester getCurrTester() {
        return currTester;
    }

    public void setCurrTester(Tester currTester) {
        this.currTester = currTester;
    }

    public Test getCurrTest() {
        return currTest;
    }

    public void setCurrTest(Test currTest) {
        this.currTest = currTest;
    }

    public List<TestResponse> getTestResponses() {
        return testResponses;
    }

    public void setTestResponses(List<TestResponse> testResponses) {
        this.testResponses = testResponses;
    }

    public void addTestRes(TestResponse testResponse){
        this.testResponses.add(testResponse);
    }
}