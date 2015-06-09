package com.epam.locationtracking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.locationtracking.service.impl.EmailConfirmationService;

@RestController
public class HelloController {
	
	@Autowired
	EmailConfirmationService emailService;

    @RequestMapping("/")
    public String index() {
    	emailService.send("Bohdan", "bkolesnyk85@gmail.com", "http:www.google.com");
        return "Greetings from Spring Boot!";
    }

}
