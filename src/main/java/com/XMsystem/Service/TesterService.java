package com.XMsystem.Service;

import com.XMsystem.Model.Test;
import com.XMsystem.Model.Tester;
import com.XMsystem.Repository.TesterRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TesterService {

    private final TesterRepository testerRepository;

    public TesterService(TesterRepository testerRepository) {
        this.testerRepository = testerRepository;
    }

    public List<Tester> getAllTesters(){
        List<Tester> testers = new ArrayList<>();
        testerRepository.findAll().forEach(testers::add);
        return testers;
    }

    public Map<Long,String> getAllTestersNames(){
        Map<Long,String> testers = new HashMap<>();
        testerRepository.findAll().forEach(tester->testers.put(tester.getId(),tester.getUserName()));
        return testers;
    }

    public void addTester (Tester tester){
        testerRepository.save(tester);
        for (Test test:tester.getTests()) {
            test.addTester(tester);
        }
    }

    public void deleteById(String id) {
        testerRepository.deleteById(Long.valueOf(id));
    }

}
