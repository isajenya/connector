package com.comunda.isa.controller;

import com.comunda.isa.Model.Person;
import com.comunda.isa.Model.Summers;
import com.comunda.isa.service.CamundaStartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class SampleController {
    @Autowired
    CamundaStartService camundaStartService;


    @GetMapping("/get")
    public String index(){
        return "Greetings from spring boot";
    }

    @RequestMapping(value = "/msgeventstart", method = RequestMethod.POST)
    public void persistPerson(@RequestBody Person obj) throws Exception {
        camundaStartService.startProcessByMessage(obj);
    }
    @PostMapping(value = "/msgs2")
    public void msgs2(@RequestBody String name){
        camundaStartService.startProcessByMessage(name);
    }

    @GetMapping("/getconnector/{name}")
    public int getConnector(@PathVariable(value = "name") String name){
        return name.length();
    }

    @PostMapping("/postconnector")
    public int msg2(@RequestBody Summers summers){
        return summers.getNum1() + summers.getNum2() + summers.getNum3() + summers.getNum4();

    }

    @GetMapping("/example")
    public String getExample(){
        return "example";
    }

    @PostMapping("/postconnector2")
    public String msg3(@RequestBody Summers summers, Model model){
        int sum = summers.getNum1() + summers.getNum2() + summers.getNum3() + summers.getNum4();
        model.addAttribute("sum", sum);
        return "sumExample";

    }


}
