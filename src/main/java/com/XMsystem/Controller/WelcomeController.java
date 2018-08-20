package com.XMsystem.Controller;

import java.util.Map;

import com.XMsystem.Model.Examinee;
import com.XMsystem.Service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WelcomeController {

//    // inject via application.properties
//    @Value("${welcome.message:test}")
//    private String message = "Hello World";
    @Autowired
    TestService testService;

    @RequestMapping("/")
    public String home(Model model) {
        return "examinee/home";
    }

//    @RequestMapping("/login")
//    public String login(Model model) {
//        model.addAttribute("message", "Welcome to spring");
//        return "login";
//    }

    @RequestMapping("examinee/signup")
    public String signUpExaminee(Model model) {
        model.addAttribute("examinee",new Examinee());
        model.addAttribute("tests",testService.getAllTests());
        return "examinee/signup";
    }
}