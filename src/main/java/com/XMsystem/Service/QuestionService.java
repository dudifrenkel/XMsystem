package com.XMsystem.Service;

import com.XMsystem.Model.Answer;
import com.XMsystem.Model.Question;
import com.XMsystem.Repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuestionService {

    private QuestionRepository questionRepository;
    private AnswerService answerService;

    @Autowired
    public QuestionService(QuestionRepository questionRepository, AnswerService answerService) {
        this.questionRepository = questionRepository;
        this.answerService = answerService;
    }

    public List<Question> getAllQuestions(){
        List<Question> questions = new ArrayList<>();
        questionRepository.findAll().forEach(questions::add);
        return questions;
    }

//    public void addQuestion (Question question){
//        questionRepository.save(question);
//    }

    public Question getQuestion(String id) {
        Optional<Question> question = questionRepository.findById(Long.valueOf(id));
        if(question.isPresent()){
            return question.get();
        }
        return null;
    }

    public void deleteById(String id) {
        Question question = getQuestion(id);
        if (question!=null) {
            /* delete all question's answers */
            for (Answer answer : question.getAnswers()) {
                answerService.delete(answer);
            }
            questionRepository.deleteById(Long.valueOf(id));
        }
    }

    public void addQuestion(Question question, List<Answer> answers) {
        questionRepository.save(question);
        for (Answer answer:answers) {
            answer.setQuestion(question);
            question.addAnswer(answer);
            answerService.addAnswer(answer);
        }
    }

    public Map<Long,String> getAllQuestionsIds(){
        Map<Long,String> questions = new HashMap<>();
        questionRepository.findAll().forEach(question->questions.put(question.getId(),question.getBody()));
        return questions;
    }
}
