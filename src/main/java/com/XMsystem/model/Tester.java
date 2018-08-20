package com.XMsystem.Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Tester {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    Long id;
    String userName;
    String password;

    @ManyToMany
    Set<Test> tests = new HashSet<>();

    @OneToMany
    Set<Examinee> examinees = new HashSet<>();

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Test> getTests() {
        return tests;
    }

    public void setTests(Set<Test> tests) {
        this.tests = tests;
    }

    public Set<Examinee> getExaminees() {
        return examinees;
    }

    public void setExaminees(Set<Examinee> examinees) {
        this.examinees = examinees;
    }
}
