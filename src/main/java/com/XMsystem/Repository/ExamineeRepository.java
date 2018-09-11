package com.XMsystem.Repository;

import com.XMsystem.Model.Examinee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ExamineeRepository extends CrudRepository<Examinee, Long> {

//    List<Examinee> findExamineesByFirstNameAndLastName(String firstName, String lastName);

}