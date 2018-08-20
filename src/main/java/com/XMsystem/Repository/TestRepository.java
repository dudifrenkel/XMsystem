package com.XMsystem.Repository;

import com.XMsystem.Model.Test;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TestRepository extends CrudRepository<Test, Long> {

//    List<Test> findTestByTestersId(Integer testerId);
}
