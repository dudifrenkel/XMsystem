package com.XMsystem.Controller;

import com.XMsystem.Service.TesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/test")
public class TestController {

    @Autowired
    TesterService testerService;

    @RequestMapping("{user}/tests/all")

    // TODO: 16/08/2018  ??session?? save the userName/userID for finding the test

    public void getAllTests(Model model, @PathVariable String id){
        model.addAttribute("tests", testerService.getTestsByTesterId(Long.valueOf(id)) );
    }
}
