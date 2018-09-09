package com.XMsystem.Controller;

import com.XMsystem.Service.QuestionService;
import com.XMsystem.Model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Question> getAll(){
        return questionService.getAllQuestions();
    }

    @GetMapping(path="/searchId/{id}")
    public @ResponseBody
    Question getQuestion(@PathVariable String id){
        return questionService.getQuestion(id);
    }

}
