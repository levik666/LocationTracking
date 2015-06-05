package com.epam.locationtracking.controller;

import com.epam.locationtracking.dto.PointDTO;
import com.epam.locationtracking.facades.LocationFacades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController("/location")
public class LocationController {

    @Autowired
    private LocationFacades locationFacades;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    List<PointDTO> location(Principal principal) {
        return locationFacades.getLocations(principal.getName());
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void addLocationPoint(@RequestBody PointDTO point, Principal principal) {
        locationFacades.add(point, principal.getName());
    }
}
