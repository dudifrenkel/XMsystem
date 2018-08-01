package com.XMsystem.Examinee;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Examinee {

    @Id//@GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String firstName;

    private String lastName;
//    private String birthDate;
//    private Character sex;

    public Examinee(){ }

    public Examinee(Integer id, String firstName, String lastName/*, String dateOfBirth, Character gender*/) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
//        this.birthDate = dateOfBirth;
//        this.sex = gender;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
/*
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
    }*/
}