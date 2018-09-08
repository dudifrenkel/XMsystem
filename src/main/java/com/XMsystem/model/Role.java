package com.XMsystem.Model;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Role extends AbstractPersistable<Long> {

    private String name;

    @OneToMany(targetEntity = Administrator.class, mappedBy = "role")
    private Set<Administrator> users;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
