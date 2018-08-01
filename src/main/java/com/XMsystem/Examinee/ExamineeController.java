package com.XMsystem.Examinee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/examinee")
public class ExamineeController {

    @Autowired
    private ExamineeRepository examineeRepository;
    private ExamineeService examineeService;

    @GetMapping(path = "/")
    public @ResponseBody String hi(){
        return "hi";
    }
    @GetMapping(path = "/all2")
    public @ResponseBody List<Examinee> getAllExaminees(){
        return examineeService.getAllExaminees();
//        return (List<Examinee>) examineeRepository.findAll();
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Examinee> getAll(){
        return examineeRepository.findAll();
    }

    @PostMapping(path="/add") // Map ONLY post Requests
    public @ResponseBody String addNewUser (@RequestParam String id
            , @RequestParam String firstName, @RequestParam String lastName) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Examinee n = new Examinee(Integer.valueOf(id),firstName,lastName);
//        n.setId(id);
//        n.setFirstName(firstName);
//        n.setLastName(lastName);
        examineeRepository.save(n);
        return "Saved";
    }

    @GetMapping(path="/init") // Map ONLY GET Requests
    public String init(){
        examineeService.init();
        return "done";
    }


}
