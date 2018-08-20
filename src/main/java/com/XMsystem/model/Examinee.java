package com.XMsystem.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity // This tells Hibernate to make a table out of this class
public class Examinee implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String taz;
    private String firstName;
    private String lastName;
    private String birthDate;
    private Character sex;
    @ManyToOne
    private Tester currTester;

    public Examinee(){
        super();
    }

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

    public Tester getCurrTester() {
        return currTester;
    }

    public void setCurrTester(Tester currTester) {
        this.currTester = currTester;
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
}