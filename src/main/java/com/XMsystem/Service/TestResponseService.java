package com.XMsystem.Service;


import com.XMsystem.Model.Test;
import com.XMsystem.Model.TestResponse;
import com.XMsystem.Repository.TestRepository;
import com.XMsystem.Repository.TestResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TestResponseService {

    @Autowired
    private TestResponseRepository testResponseRepository;

//    public List<Test> getTestsByTesterId(Integer testerID){
//        List<Test> tests = new ArrayList<>();
//        testRepository.findTestByTestersId(testerID).forEach(tests::add);
//        return tests;
//    }


//    public List<Test> getAllTests(){
//        List<Test> tests = new ArrayList<>();
//        testRepository.findAll().forEach(tests::add);
//        return tests;
//    }



//    public Test getTestById(String id) {
//        Optional <Test> testOptional = testRepository.findById(Long.valueOf(id));
//        if (testOptional.isPresent()){
//            return testOptional.get();
//        }
//        return null;
//    }

    public void addTestResponse(TestResponse testResponse) {
        testResponseRepository.save(testResponse);
    }

//    public void deleteById(String id) {
//        Test test = getTestById(id);
//        if (test != null) {
//            for (Tester tester : test.getTesters()) {
//                tester.removeTest(test.getId());
//            }
//            testRepository.deleteById(Long.valueOf(id));
//        }
//    }

}
