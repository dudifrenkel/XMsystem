package com.XMsystem.Service;

import com.XMsystem.Model.Questionnaire;
import com.XMsystem.Repository.QuestionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuestionnaireService {

    private final QuestionnaireRepository questionnaireRepository;

    public QuestionnaireService(QuestionnaireRepository questionnaireRepository) {
        this.questionnaireRepository = questionnaireRepository;
    }

    public List<Questionnaire> getAllquestionnaires(){
        List<Questionnaire> questionnaires = new ArrayList<>();
        questionnaireRepository.findAll().forEach(questionnaires::add);
        return questionnaires;
    }

    public void addQuestionnaire (Questionnaire questionnaire){
        questionnaireRepository.save(questionnaire);
    }

    public Questionnaire getQuestionnaire(String id) {
        Optional<Questionnaire> questionnaire = questionnaireRepository.findById(Long.valueOf(id));
        if(questionnaire.isPresent()){
            return questionnaire.get();
        }
        return null;
    }


    public void deleteById(String id) {
        questionnaireRepository.deleteById(Long.valueOf(id));
    }

    public Map<Long,String> getAllQuesDiscriptions(){
        Map<Long,String> qnnaires = new HashMap<>();
        questionnaireRepository.findAll().forEach(qnnaire->qnnaires.put(
                                                        qnnaire.getId(),qnnaire.getDescription()));
        return qnnaires;
    }
}
