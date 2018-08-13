package com.XMsystem.Examinee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ExamineeService {

    @Autowired
    private ExamineeRepository examineeRepository;

    public List<Examinee> getAllExaminees(){
        List<Examinee> examinees = new ArrayList<>();
        examineeRepository.findAll().forEach(examinees::add);
        return examinees;
    }

    public void addExaminee (Examinee examinee){
        examineeRepository.save(examinee);
    }

    public Examinee getExaminee(String id) {
        Optional<Examinee> examinee = examineeRepository.findById(Integer.valueOf(id));
        if(examinee.isPresent()){
            return examinee.get();
        }
        return null;
    }

    public List<Examinee> getExamineeByName(String firstName, String lastName) {
        return examineeRepository.findExamineesByFirstNameAndLastName(firstName,lastName);
    }
}
