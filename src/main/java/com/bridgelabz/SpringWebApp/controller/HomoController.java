package com.bridgelabz.SpringWebApp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomoController //handles/accept Request and respond by methods
{
    @RequestMapping("/")
    public String greet()
    {
        System.out.println("method is called");
        return "welcome to spring boot";
    }
    @RequestMapping("/about")
    public String about()
    {
        return "we don't teach we educate";
    }
}
