package com.XMsystem.Examinee;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ExamineeRepository extends CrudRepository<Examinee, Integer> {

    List<Examinee> findExamineesByFirstNameAndLastName(String firstName, String lastName);

}