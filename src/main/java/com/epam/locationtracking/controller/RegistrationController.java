package com.epam.locationtracking.controller;

import com.epam.locationtracking.dto.UserDTO;
import com.epam.locationtracking.facades.RegistrationFacades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegistrationController {

    @Autowired
    private RegistrationFacades registrationFacades;

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public void registration(@RequestBody UserDTO user) {
        registrationFacades.registration(user);
    }


}
