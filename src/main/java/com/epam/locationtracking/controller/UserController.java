package com.epam.locationtracking.controller;

import com.epam.locationtracking.dto.UserDTO;
import com.epam.locationtracking.facades.UserFacades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller("/user")
public class UserController {

    @Autowired
    private UserFacades userFacades;

    /*@RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<String> getUsers(){
        return userFacades.getUsers();
    }*/

/*    @RequestMapping(value = "/currentUser", method = RequestMethod.GET)
    public @ResponseBody String getCurrentUser(Principal principal){
        return userFacades.getUser(principal.getName());
    }*/

    /*@RequestMapping(method = RequestMethod.PUT)
    public void updateUser(@RequestBody UserDTO user, Principal principal){
        userFacades.updateUser(user, principal.getName());
    }*/

    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(Principal principal){
        userFacades.delete(principal.getName());
    }

    @RequestMapping(method = RequestMethod.POST)
    public void registration(@RequestBody UserDTO user) {
        userFacades.registration(user);
    }

}
