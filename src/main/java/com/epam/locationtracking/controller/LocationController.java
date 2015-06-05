package com.epam.locationtracking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LocationController {

    @RequestMapping(value = "/location", method = RequestMethod.GET)
    public @ResponseBody String location() {
        return "Stub users locations";
    }
}
