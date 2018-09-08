package com.XMsystem.Repository;

import com.XMsystem.Model.Test;
import com.XMsystem.Model.Tester;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TesterRepository extends CrudRepository<Tester, Long> {

    List<Test> findTestsById(Long testerId);
}
