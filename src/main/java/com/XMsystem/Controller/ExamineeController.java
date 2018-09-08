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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes({"examinee","testers","qnnaireIterator","currQnnaire","startQuesTime","tRes"})
@RequestMapping(value = "/examinee")
public class ExamineeController {



    private final ExamineeService examineeService;
    private final TesterService testerService;
    private final TestResponseService testResponseService;
    private final QuestionnaireService questionnaireService;
    private final QuestionnaireResponseService questionnaireResponseService;
    private final ExamineeAnswerService examineeAnswerService;
    private final AnswerService answerService;

    @Autowired
    private TestService testService;

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

    @Autowired


    //    @RequestMapping("examineeEntrance")
//    public String welcomeExaminee() {
//        return "examinee/examineeWelcome";
//    }
//
    @ModelAttribute("examinee")
    public Examinee getExaminee () {
        return new Examinee();
    }

    @RequestMapping("examineeEntrance")
    public String createExamineePage(Model model) {
//        model.addAttribute("examinee",new Examinee());
        model.addAttribute("testers",testerService.getAlltestersNames());
        return "examinee/examineeSignup";
    }
//
//    @GetMapping(path = "/all")
//    public @ResponseBody Iterable<Examinee> getAll(){
//        return examineeService.getAllExaminees();
//    }
//
//    @GetMapping(path="/searchName/{firstName_lastName}")
//    public @ResponseBody
//    List<Examinee> getExamineeByName(@PathVariable String firstName_lastName){
//        // TODO format check for inputs
//        String[] name = firstName_lastName.split("_");
//        return examineeService.getExamineeByName(name[0],name[1]);
//    }
//
//    @GetMapping(path="/searchId/{id}")
//    public @ResponseBody
//    Examinee getExaminee(@PathVariable String id){
//        return examineeService.getExaminee(id);
//    }

    @PostMapping(path="/add") // Map ONLY post Requests
    public String addNewExaminee (
            @Valid @ModelAttribute("examinee") Examinee examinee, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){
            return "examinee/examineeSignup";
        }
        examineeService.addExaminee(examinee);
        model.addAttribute("tests", (examinee.getCurrTester().getTests()));
        return "/examinee/chooseTest";
    }

    @PostMapping(path="/begin")
    public String InitTest1 (@ModelAttribute("examinee") Examinee examinee,
                             Model model){
        /* Setting the examinee the response */
        TestResponse testResponse = new TestResponse(LocalDateTime.now().toString());
        testResponse.setDescription(examinee.getCurrTest().getDescription());
        testResponse.setExaminee(examinee);

//        testResponseService.addTestResponse(testResponse);
//        examinee.addTestRes(testResponse);

        List<String> qnnairesTestList = examinee.getCurrTest().getQnnaireIds();
        Iterator<String> iterator = qnnairesTestList.iterator();
        model.addAttribute("qnnaireIterator",iterator);
        model.addAttribute("tRes",testResponse);

        return "redirect:questionnairePage";

    }

    //Todo: TESTTTTT!
    @GetMapping(path="/begin")
    public String InitTest11 (//@ModelAttribute("examinee") Examinee examinee,
                             Model model){
        /* Setting the examinee the response */
        TestResponse testResponse = new TestResponse(LocalDateTime.now().toString());
        Examinee examinee = examineeService.getExaminee("244");
        examinee.setCurrTest(testService.getTestById("308"));
        testResponse.setDescription(examinee.getCurrTest().getDescription());

        testResponse.setExaminee(examinee);

//        testResponseService.addTestResponse(testResponse);
//        examinee.addTestRes(testResponse);

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
//            LocalDateTime startQuesTime =
            model.addAttribute("startQuesTime",LocalDateTime.now());
            return "examinee/questionnairePage";
        }
        testResponseService.addTestResponse(tRes);
        examinee.addTestRes(tRes);
        status.setComplete();
        model.addAttribute("name",examinee.getFirstName());
        return "examinee/finish";
//        return  qnnaireFormHelper(iterator, model);
    }

//    private String qnnaireFormHelper(Iterator<String> iterator,Model model){
//        if (iterator.hasNext()){
//            String qnnaireId = iterator.next();
//            Questionnaire currQnnaire = questionnaireService.getQuestionnaire(qnnaireId);
//            model.addAttribute("currQnnaire",currQnnaire);
//            return "examinee/questionnairePage";
//        }
//        return "examinee/finish";
//    }

    @PostMapping(path="/processQnnaire")
    public  String processQnnaire (@RequestParam Map<String,String> formAnswers,
                                   @ModelAttribute("currQnnaire") Questionnaire currQnnaire,
                                   @ModelAttribute("tRes") TestResponse tRes,
                                   @ModelAttribute ("startQuesTime") LocalDateTime startQuesTime){

        /* handle questionnaire time by measure the time passed until the submit + 5 sec of delay */
        LocalDateTime endQuesTime = LocalDateTime.now();
        handleQnnaireTime(startQuesTime,endQuesTime,tRes);
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

    private void handleQnnaireTime(LocalDateTime startQuesTime, LocalDateTime endQuesTime, TestResponse tRes) {
    }

//    @RequestMapping(value = "processQnnaire/{answerId}", method = RequestMethod.GET)
//    public String deleteTester(@PathVariable String answerId,
//                               @ModelAttribute QuestionnaireResponse questionnaireResponse){
//        Long questionId;
//        ExamineeAnswer examineeAnswer = questionnaireResponse.setExaminneAnswer(answerId);
//
//        return "redirect:/admin/manageUsers";
//    }


//    @PostMapping(path="/add") // Map ONLY post Requests
//    public @ResponseBody String addUser (@RequestBody Examinee examinee){
//        // TODO: 01/08/2018 format check for inputs
//        examineeService.addExaminee(examinee);
//        return "Saved";
//    }

}