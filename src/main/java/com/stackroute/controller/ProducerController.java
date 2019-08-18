package com.stackroute.controller;

import com.stackroute.domain.Movie;
import com.stackroute.domain.User;
import com.stackroute.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/")
public class ProducerController {

    @Autowired
    private ProducerService producerService;

    /**
     * Constructor based Dependency injection to inject TrackService into controller
     */

    public ProducerController(ProducerService producerService) {
        this.producerService = producerService;
    }


    @RequestMapping("/send")
    public String sendMessage(@RequestParam("msg") String msg) {
        producerService.produceMsg(msg);
        return "Msg Sent Successfully ";
    }
}
