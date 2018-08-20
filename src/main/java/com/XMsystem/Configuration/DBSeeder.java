//package com.XMsystem.Configuration;
//
//import com.XMsystem.Model.*;
//import com.XMsystem.Repository.AnswerRepository;
//import com.XMsystem.Repository.QuestionRepository;
//import com.XMsystem.Repository.QuestionnaireRepository;
//import com.XMsystem.Repository.TestRepository;
//import com.XMsystem.Service.QuestionService;
//import com.XMsystem.Service.QuestionnaireService;
//import com.XMsystem.Service.TestService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//@Component
//public class DBSeeder implements CommandLineRunner {
//
//    TestRepository testRepository;
//    QuestionnaireRepository questionnaireRepository;
//    QuestionRepository questionRepository;
//    AnswerRepository answerRepository;
//
//    public DBSeeder(TestRepository testRepository, QuestionnaireRepository questionnaireRepository,
//                    QuestionRepository questionRepository, AnswerRepository answerRepository) {
//        this.testRepository = testRepository;
//        this.questionnaireRepository = questionnaireRepository;
//        this.questionRepository = questionRepository;
//        this.answerRepository = answerRepository;
//    }
//
//    @Override
//    public void run(String... strings) throws Exception {
//
//        Test t1 = new Test("מבחן 2 טפסים");
//        Test t2 = new Test("מבחן טופס 1");
//        Questionnaire questionnaire1 = new Questionnaire("שאלון 1", 30);
//        Questionnaire questionnaire2 = new Questionnaire("שאלון 2", 30);
//        Questionnaire questionnaire3 = new Questionnaire("שאלון 3", 30);
//        Question q1 = new Question("מה צבע השמיים?");
//        Question q2 = new Question("מי היה ראש הממשלה הראשון של ישראל?");
//        Question q3 = new Question("1+1=?");
//        List<Answer> answersList = new ArrayList<>();
//
//        Answer ansq11 = new Answer("צהוב",false);
//        Answer ansq12 = new Answer("כחול",true);
//        Answer ansq13 = new Answer("לבן",false);
//
//        Answer ansq21 = new Answer("דוד",true);
//        Answer ansq22 = new Answer("כחול",false);
//        Answer ansq23 = new Answer("משה",false);
//
//        Answer ansq31 = new Answer("3",false);
//        Answer ansq32 = new Answer("2",true);
//        Answer ansq33 = new Answer("0",false);
//
//
//        q1.addAnswer(ansq11);
//        q1.addAnswer(ansq13);
////        q1.setCorrectAns(ansq12);
//        q1.addAnswer(ansq12);
//
//        q2.addAnswer(ansq22);
//        q2.addAnswer(ansq23);
////        q2.setCorrectAns(ansq21);
//        q2.addAnswer(ansq21);
//
//        q3.addAnswer(ansq31);
//        q3.addAnswer(ansq33);
////        q3.setCorrectAns(ansq32);
//        q3.addAnswer(ansq32);
//
//
//        questionnaire1.addQuestion(q1);
//        questionnaire1.addQuestion(q2);
//
//        questionnaire2.addQuestion(q3);
//
//        t1.addQuestionnaires(questionnaire1);
//        t1.addQuestionnaires(questionnaire2);
//        t2.addQuestionnaires(questionnaire3);
//
//        ansq11.setQuestion(q1);
//        ansq12.setQuestion(q1);
//        ansq13.setQuestion(q1);
//        ansq21.setQuestion(q2);
//        ansq22.setQuestion(q2);
//        ansq23.setQuestion(q2);
//        ansq31.setQuestion(q3);
//        ansq32.setQuestion(q3);
//        ansq33.setQuestion(q3);
//
//        // questions
//        questionRepository.save(q1);
//        questionRepository.save(q2);
//        questionRepository.save(q3);
//
//        // answers
//        answerRepository.save(ansq11);
//        answerRepository.save(ansq12);
//        answerRepository.save(ansq13);
//
//        answerRepository.save(ansq21);
//        answerRepository.save(ansq22);
//        answerRepository.save(ansq23);
//
//        answerRepository.save(ansq31);
//        answerRepository.save(ansq32);
//        answerRepository.save(ansq33);
//
//
//
//        //questionnaires
//        questionnaireRepository.save(questionnaire1);
//        questionnaireRepository.save(questionnaire2);
//        questionnaireRepository.save(questionnaire3);
//
//        // tests
//        testRepository.save(t1);
//        testRepository.save(t2);
//
//    }
//}