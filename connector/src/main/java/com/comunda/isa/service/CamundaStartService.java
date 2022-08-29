package com.comunda.isa.service;

import com.comunda.isa.Model.Person;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CamundaStartService {
    @Autowired
    RuntimeService runtimeService;

    public void startProcessByMessage(Person person){
        runtimeService.createMessageCorrelation("msg-s-2")
                .setVariable("name", person.getName())
                .setVariable("gender", person.getGender())
                .correlate();

    }

    public void startProcessByMessage(String name){
        runtimeService.createMessageCorrelation("msg-s-2")
                .setVariable("name", name)
                .correlate();
    }





}
