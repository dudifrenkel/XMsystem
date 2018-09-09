package com.XMsystem.Controller;

import com.XMsystem.Model.*;
import com.XMsystem.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes({"examinee","testers","qnnaireIterator","currQnnaire","startQuesTime","tRes"})
@RequestMapping(value = "/examinee")
public class ExamineeController {

    @Autowired
    TestService testService;

    private final ExamineeService examineeService;
    private final TesterService testerService;
    private final TestResponseService testResponseService;
    private final QuestionnaireService questionnaireService;
    private final QuestionnaireResponseService questionnaireResponseService;
    private final ExamineeAnswerService examineeAnswerService;
    private final AnswerService answerService;

    public ExamineeController(ExamineeService examineeService, TesterService testerService,
                              TestResponseService testResponseService, QuestionnaireService
                                      questionnaireService, QuestionnaireResponseService
                                      questionnaireResponseService, ExamineeAnswerService
                                      examineeAnswerService, AnswerService answerService) {
        this.examineeService = examineeService;
        this.testerService = testerService;
        this.testResponseService = testResponseService;
        this.questionnaireService = questionnaireService;
        this.questionnaireResponseService = questionnaireResponseService;
        this.examineeAnswerService = examineeAnswerService;
        this.answerService = answerService;
    }

    @ModelAttribute("examinee")
    public Examinee getExaminee () {
        return new Examinee();
    }

    @RequestMapping("examineeEntrance")
    public String createExamineePage(Model model) {
        model.addAttribute("testers",testerService.getAllTestersNames());
        return "examinee/examineeSignup";
    }

    @PostMapping(path="/add")
    public String addNewExaminee (
            @Valid @ModelAttribute("examinee") Examinee examinee, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "examinee/examineeSignup";
        }
        examineeService.addExaminee(examinee);
        model.addAttribute("tests", (examinee.getCurrTester().getTests()));
        return "/examinee/chooseTest";
    }

    //Todo: TESTTTTT!
    @GetMapping(path="/begin")
    public String InitTest11 (//@ModelAttribute("examinee") Examinee examinee,
                              Model model) {
        /* Setting the examinee the response */
        TestResponse testResponse = new TestResponse(LocalDateTime.now().toString());
        Examinee examinee = examineeService.getExaminee("244");
        examinee.setCurrTest(testService.getTestById("387"));
        testResponse.setDescription(examinee.getCurrTest().getDescription());

        testResponse.setExaminee(examinee);
        List<String> qnnairesTestList = examinee.getCurrTest().getQnnaireIds();
        Iterator<String> iterator = qnnairesTestList.iterator();
        model.addAttribute("qnnaireIterator",iterator);
        model.addAttribute("tRes",testResponse);

        return "redirect:questionnairePage";
    }
    @PostMapping(path="/begin")
    public String InitTest1 (@ModelAttribute("examinee") Examinee examinee,
                             Model model){
        /* Setting the examinee the response */
        TestResponse testResponse = new TestResponse(LocalDateTime.now().toString());
        testResponse.setDescription(examinee.getCurrTest().getDescription());
        testResponse.setExaminee(examinee);

        List<String> qnnairesTestList = examinee.getCurrTest().getQnnaireIds();
        Iterator<String> iterator = qnnairesTestList.iterator();
        model.addAttribute("qnnaireIterator",iterator);
        model.addAttribute("tRes",testResponse);

        return "redirect:questionnairePage";
    }

    @GetMapping(path="/questionnairePage")
    public String questionnairePage (@ModelAttribute("qnnaireIterator") Iterator<String> iterator,
                                     @ModelAttribute("examinee") Examinee examinee,
                                     @ModelAttribute("tRes") TestResponse tRes,
                                     Model model, SessionStatus status){
        if (iterator.hasNext()){
            String qnnaireId = iterator.next();
            Questionnaire currQnnaire = questionnaireService.getQuestionnaire(qnnaireId);
            model.addAttribute("currQnnaire",currQnnaire);
            model.addAttribute("startQuesTime",LocalDateTime.now());
            return "examinee/questionnairePage";
        }
        testResponseService.addTestResponse(tRes);
        examinee.addTestRes(tRes);
        status.setComplete();
        model.addAttribute("name",examinee.getFirstName());
        return "examinee/finish";
    }

    @PostMapping(path="/processQnnaire")
    public  String processQnnaire (@RequestParam Map<String,String> formAnswers,
                                   @ModelAttribute("currQnnaire") Questionnaire currQnnaire,
                                   @ModelAttribute("tRes") TestResponse tRes,
                                   @ModelAttribute ("startQuesTime") LocalDateTime startQuesTime){

        /* handle questionnaire time by measure the time passed until the submit + 5 sec of delay */
        LocalDateTime endQuesTime = LocalDateTime.now();
        Duration duration = Duration.between(startQuesTime,endQuesTime);
        Duration maxDealey = Duration.ofSeconds(5).plusMinutes(currQnnaire.getDurationMin());
        if (duration.compareTo(maxDealey)>0){   // In case of evil client the test will continue
            tRes.setNotes(tRes.getNotes()+" "+"In "+currQnnaire.getDescription()+ //and note will be added
                                                " delay of: "+duration.getSeconds()+" sec");
        }

        QuestionnaireResponse qRes = new QuestionnaireResponse(currQnnaire);
        Map<Long,ExamineeAnswer> ansList = qRes.getAnswers();
        ExamineeAnswer examineeAnswer;
        Answer answer;

        /* process the form - insert the examinee answers into the appropriate objects */
        for (Map.Entry<String,String> formAnswer : formAnswers.entrySet()) {
            if (formAnswer.getKey().equals("_csrf")){
                continue;
            }
            answer = answerService.getQuestion(formAnswer.getValue());  // get the Question of the answer
            examineeAnswer = ansList.get(Long.valueOf(formAnswer.getKey()));    // get the examinee answer
            examineeAnswer.setAnswer(answer.getContent());  // set the examinee answer in examineeAnswer object
            if(answer.isCorrect()){     // change the answer's correctness if true (false by default)
               examineeAnswer.setCorrect(true);
            }
        }
        qRes.calcCorrectQuestions();
        examineeAnswerService.addExamineeAnswer(qRes.getAnswers());
        questionnaireResponseService.addQuestionnaireResponse(qRes);
        tRes.setQnaaireResponse(qRes);
        return "redirect:questionnairePage";
    }
}
