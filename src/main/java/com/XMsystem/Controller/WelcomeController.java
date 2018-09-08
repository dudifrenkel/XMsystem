package com.XMsystem.Controller;

import com.XMsystem.Service.TesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
public class WelcomeController {

//    // inject via application.properties
//    @Value("${welcome.message:test}")
//    private String message = "Hello World";
    @Autowired
TesterService testerService;

    @GetMapping("/")
    public String home(Model model) {
        return "home";
    }

    @GetMapping("/showMyLogin")
    public String showMyLogin(){
//        return "login";
        return "fancy-login";
    }

//    @RequestMapping("/login")
//    public String login(Model model) {
//        model.addAttribute("message", "Welcome to spring");
//        return "login";
//    }

//    @RequestMapping("examinee/signup")
//    public String signUpExaminee(Model model) {
//        model.addAttribute("examinee",new Examinee());
//        model.addAttribute("testers",testerService.getAlltesters());
//        return "examinee/signup";
//    }
}