package com.XMsystem.Examinee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/examinee")
public class ExamineeController {

    @Autowired
    private ExamineeService examineeService;

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Examinee> getAll(){
        return examineeService.getAllExaminees();
    }

    @GetMapping(path="/searchName/{firstName_lastName}")
    public @ResponseBody
    List<Examinee> getExamineeByName(@PathVariable String firstName_lastName){
        // TODO format check for inputs
        String[] name = firstName_lastName.split("_");
        return examineeService.getExamineeByName(name[0],name[1]);
    }

    @GetMapping(path="/searchId/{id}")
    public @ResponseBody
    Examinee getExaminee(@PathVariable String id){
        return examineeService.getExaminee(id);
    }

    @PostMapping(path="/add") // Map ONLY post Requests
    public @ResponseBody String addNewUser (@RequestBody Examinee examinee){
        // TODO: 01/08/2018 format check for inputs
        examineeService.addExaminee(examinee);
        return "Saved";
    }
}
