package com.XMsystem.Question;

import com.XMsystem.Examinee.Examinee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping(path="/add") // Map ONLY post Requests
    public @ResponseBody String addNewQuestion (@RequestBody Question question){
        // TODO: 01/08/2018 format check for inputs
        questionService.addQuestion(question);
        return "Saved";
    }
}
