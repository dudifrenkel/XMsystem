package com.XMsystem.Controller;

import com.XMsystem.Model.*;
import com.XMsystem.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes({"admin","testerTestsList"})
@RequestMapping(value = "/admin")
public class AdminController {

    public static final String QUESTION_BODY_KEY = "body";
    public static final String CORRECT_ANSWER_PREFIX_KEY = "ans_";
    public static final String CORRECT_ANSWER_NUM_KEY = "correctAnswerNum";

    private final AdministratorService administratorService;
    private final TesterService testerService;
    private final TestService testService;
    private final QuestionnaireService questionnaireService;
    private final QuestionService questionService;
    private final AnswerService answerService;
    private final ExamineeService examineeService;

    public AdminController(AdministratorService administratorService, TesterService testerService,
                           TestService testService, QuestionnaireService questionnaireService,
                           QuestionService questionService, AnswerService answerService,
                           ExamineeService examineeService) {
        this.administratorService = administratorService;
        this.testerService = testerService;
        this.testService = testService;
        this.questionnaireService = questionnaireService;
        this.questionService = questionService;
        this.answerService = answerService;
        this.examineeService = examineeService;
    }

    @RequestMapping(value = "adminsEntrance")
    public String adminsEntrance() {
        return "admin/adminWelcome";
    }

    @RequestMapping(value = "manageUsers")
    public String showUserBoard(Model model) {
        model.addAttribute("admins", administratorService.getAllAdministrators());
        model.addAttribute("testers", testerService.getAllTesters());
        model.addAttribute("examinees", examineeService.getAllExaminees());
        return "admin/usersManagement";
    }

    @RequestMapping(value = "manageTests")
    public String showTestBoard(Model model) {
        model.addAttribute("tests", testService.getAllTests());
        model.addAttribute("questionnaires", questionnaireService.getAllquestionnaires());
        model.addAttribute("questions", questionService.getAllQuestions());
        return "admin/testsManagement";
    }

    @RequestMapping("createAdmin")
    public String createAdminPage(Model model) {
        model.addAttribute("admin",new Administrator());
        return "admin/adminSignUp";
    }

    @GetMapping("createTester")
    public String createTesterPage(Model model) {
        model.addAttribute("tester", new Tester());
        model.addAttribute("tests", testService.getAlltestsDiscriptions());
        model.addAttribute("testerTestsList", new ArrayList<String>());
        return "admin/testerSignUp";
    }


    @RequestMapping("createQuestion")
    public String createQuestionPage(Model model) {
        model.addAttribute("question",new Question());
        return "admin/questionForm";
    }


    @RequestMapping("createQuestionnaire")
    public String createQuestionnairePage(Model model) {
        model.addAttribute("questionnaire",new Questionnaire());
        model.addAttribute("questions", questionService.getAllQuestionsIds());
        return "admin/questionnaireForm";
    }

    @RequestMapping("createTest")
    public String createTestPage(Model model) {
        model.addAttribute("test",new Test());
        model.addAttribute("questionnaires", questionnaireService.getAllQuesDiscriptions());
        return "admin/testForm";
    }

    @RequestMapping(value = "addAdmin", method = RequestMethod.POST)
    public String addAdmin(@ModelAttribute("admin") Administrator administrator, Model model){
        administratorService.addAdministrator(administrator);
        return "redirect:manageUsers";
    }

    @RequestMapping(value = "addTester", method = RequestMethod.POST)
    public String addTester(@ModelAttribute("tester") Tester tester){
        testerService.addTester(tester);
        return "redirect:manageUsers";
    }

    @RequestMapping(value = "addQuestion", method = RequestMethod.POST)
    public String addQuestion(@RequestParam Map<String,String> param){
        List<Answer> answers = new ArrayList<>();
        /* Handle Question body */
        Question question = new Question(param.get(QUESTION_BODY_KEY));
        param.remove(QUESTION_BODY_KEY);

        String correctAnswerKey = CORRECT_ANSWER_PREFIX_KEY + param.get(CORRECT_ANSWER_NUM_KEY);
        param.remove(CORRECT_ANSWER_NUM_KEY);

        /* Handle correct answer first */
        Answer answer = new Answer(param.get(correctAnswerKey),true);
        answers.add(answer);
        param.remove(correctAnswerKey);

        for(Map.Entry<String, String> entry : param.entrySet()) {
            answer = new Answer(entry.getValue(), false);
            answers.add(answer);
        }

        questionService.addQuestion(question,answers);
        return "redirect:manageTests";
    }

    @RequestMapping(value = "addQuestionnaire", method = RequestMethod.POST)
    public String addQuestionnaire(
            @ModelAttribute("questionnaire") Questionnaire questionnaire){
        questionnaireService.addQuestionnaire(questionnaire);
        return "redirect:manageTests";
    }

    @RequestMapping(value = "addTest", method = RequestMethod.POST)
    public String addTest(@ModelAttribute("test") Test test){
        testService.addTest(test);
        return "redirect:manageTests";
    }

//    @GetMapping(path = "/all")
//    public @ResponseBody Iterable<Administrator> getAll(){
//        return administratorService.getAllAdministrators();
//    }

    @RequestMapping(value = "deleteAdmin/{adminId}", method = RequestMethod.GET)
    public String deleteAdmin(@PathVariable String adminId){
        administratorService.deleteById(adminId);
        return "redirect:/admin/manageUsers";
    }

    @RequestMapping(value = "deleteTester/{testerId}", method = RequestMethod.GET)
    public String deleteTester(@PathVariable String testerId){
        testerService.deleteById(testerId);
        return "redirect:/admin/manageUsers";
    }

    @RequestMapping(value = "deleteQuestion/{questionId}", method = RequestMethod.GET)
    public String deleteQuestion(@PathVariable String questionId){
        questionService.deleteById(questionId);
        return "redirect:/admin/manageTests";
    }

    @RequestMapping(value = "deleteQuestionnaire/{questionnaireId}", method = RequestMethod.GET)
    public String deleteQuestionnaire(@PathVariable String questionnaireId){
        questionnaireService.deleteById(questionnaireId);
        return "redirect:/admin/manageTests";
    }

    @RequestMapping(value = "deleteTest/{testId}", method = RequestMethod.GET)
    public String deleteTest(@PathVariable String testId){
        testService.deleteById(testId);
        return "redirect:/admin/manageTests";
    }

    @RequestMapping(value = "getDetails/{examineeId}", method = RequestMethod.GET)
    public String getExamineePage(@PathVariable String examineeId, Model model){
        Examinee examinee = examineeService.getExaminee(examineeId);
        model.addAttribute("name",examinee.getFirstName()+" "+examinee.getLastName());
        model.addAttribute("tests",examinee.getTestResponses());
        return "admin/examineeDetails";
    }

//    @GetMapping(path="/searchId/{id}")
//    public @ResponseBody
//    Administrator getAdministrator(@PathVariable String id){
//        return administratorService.getAdministrator(id);
//    }
}
