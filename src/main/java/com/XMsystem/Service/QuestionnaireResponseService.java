package com.XMsystem.Service;


import com.XMsystem.Model.QuestionnaireResponse;
import com.XMsystem.Model.Test;
import com.XMsystem.Repository.QuestionnaireResponseRepository;
import com.XMsystem.Repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuestionnaireResponseService {

    @Autowired
    private QuestionnaireResponseRepository questionnaireResponseRepository;

//    public List<Test> getTestsByTesterId(Integer testerID){
//        List<Test> tests = new ArrayList<>();
//        testRepository.findTestByTestersId(testerID).forEach(tests::add);
//        return tests;
//    }

//
//    public List<Test> getAllTests(){
//        List<Test> tests = new ArrayList<>();
//        testRepository.findAll().forEach(tests::add);
//        return tests;
//    }
//
//    public Map<Long,String> getAlltestsDiscriptions(){
//        Map<Long,String> tests = new HashMap<>();
//        testRepository.findAll().forEach(test->tests.put(test.getId(),test.getDescription()));
//        return tests;
//    }
//
//    public List<Test> getTestsById(ArrayList<String> testsIds) {
//        List<Test> tests = new ArrayList<>();
//        Optional <Test> testOptional;
//        for (String id: testsIds) {
//            testOptional = testRepository.findById(Long.valueOf(id));
//            if (testOptional.isPresent()){
//                tests.add(testOptional.get());
//            }
//        }
//        return tests;
//    }
//
//    public Test getTestById(String id) {
//        Optional <Test> testOptional = testRepository.findById(Long.valueOf(id));
//        if (testOptional.isPresent()){
//            return testOptional.get();
//        }
//        return null;
//    }

    public void addQuestionnaireResponse(QuestionnaireResponse questionnaireResponse) {
        questionnaireResponseRepository.save(questionnaireResponse);
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
