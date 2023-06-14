package com.alpha.orderingservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HOmeController {


    @GetMapping("/")
    public String home(){
        return "index";
    }
}
