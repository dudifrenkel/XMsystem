package com.XMsystem.Tester;

import com.XMsystem.Examinee.Examinee;
import com.XMsystem.Test.Test;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Tester {
    @Id
    Integer id;

    @ManyToMany
    Set<Test> activeTest = new HashSet<>();

    @OneToMany
    Set<Examinee> activeExaminees = new HashSet<>();



}
