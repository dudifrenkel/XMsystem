package com.XMsystem.Controller;

import com.XMsystem.Service.LoginService;
import com.XMsystem.Service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/tester")
public class TesterController {

    @Autowired
    LoginService service;
    TestService testService;

    @GetMapping
    public String showTesterLoginPage(Model model){
        return "testerLogin";
    }
    @PostMapping
    public String showTesterPage(ModelMap model, @RequestParam(name = "name") String user,
                                    @RequestParam(name = "password") String pw){

        boolean isValid = service.validateTester(user,pw);
        if(!isValid){
            model.put("errorMsg","שם משתמש או סיסמא שגויים");
            return "testerLogin";
        }

        model.put("user", user);
        model.put("pw",pw);

        return "testerView";
    }

//    @RequestMapping("{user}/tests/all")
//
//    // TODO: 16/08/2018  ??session?? save the userName/userID for finding the test
//
//    public String getAllTests(Model model, @PathVariable String id){
//        model.addAttribute("tests", testService.getTestsByTesterId(Integer.valueOf(id)) );
//        return "/test/list";
//    }
}
