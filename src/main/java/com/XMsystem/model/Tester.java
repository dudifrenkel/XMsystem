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
    @JoinTable(
            name = "Tester_tests",
            joinColumns = {@JoinColumn(name = "tester_id")},
            inverseJoinColumns = {@JoinColumn(name = "test_id")}
    )
//    List<Test> tests = new ArrayList<>();
    Set<Test> tests = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER)
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

//    public List<Test> getTests() {
//        return tests;
//    }
//
//    public void setTests(List<Test> tests) {
//        this.tests = tests;
//    }

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

    public void removeTest(Long id){
        this.tests.remove(id);
    }
}
