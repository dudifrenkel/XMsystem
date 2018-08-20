package com.XMsystem.Service;


import com.XMsystem.Model.Test;
import com.XMsystem.Repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestService {

    @Autowired
    private TestRepository testRepository;

//    public List<Test> getTestsByTesterId(Integer testerID){
//        List<Test> tests = new ArrayList<>();
//        testRepository.findTestByTestersId(testerID).forEach(tests::add);
//        return tests;
//    }

    public List<Test> getAllTests(){
        List<Test> tests = new ArrayList<>();
        testRepository.findAll().forEach(tests::add);
        return tests;
    }
}
