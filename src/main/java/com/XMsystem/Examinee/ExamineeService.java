package com.XMsystem.Examinee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ExamineeService {

    @Autowired
    private ExamineeRepository examineeRepository;
    private List<Examinee> examinees = Arrays.asList(
            new Examinee(1,"yo","si"/*,"01-01-1990",'M'*/),
            new Examinee(2,"do","li"/*,"01-02-1990",'F'*/)
    );

    public List<Examinee> getAllExaminees(){
//        return examinees;
        List<Examinee> examinees = new ArrayList<>();
        examineeRepository.findAll().forEach(examinees::add);
        return examinees;
    }

    public void addExaminee (Examinee examinee){
        examineeRepository.save(examinee);
    }

    public void init (){
        examineeRepository.saveAll(examinees);
    }
}
