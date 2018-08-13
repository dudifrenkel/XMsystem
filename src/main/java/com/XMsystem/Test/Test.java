package com.XMsystem.Test;

import com.XMsystem.Questionnaire.Questionnaire;
import com.XMsystem.Tester.Tester;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Test implements Serializable {
    @Id
    Integer id;

    @ManyToMany
    Set<Questionnaire> questionnaires;

    @ManyToMany
    Set<Tester> activeOnTesters = new HashSet<>();

}
