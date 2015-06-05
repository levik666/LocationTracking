package com.epam.locationtracking.facades;

import com.epam.locationtracking.dto.PointDTO;
import com.epam.locationtracking.entity.CustomUser;
import com.epam.locationtracking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocationFacades {

    @Autowired
    private UserRepository userRepository;

    public List<PointDTO> getLocations(final String username){
        final CustomUser user = userRepository.findByLogin(username);

        if (user.getPoints() == null) {
            user.setPoints(new ArrayList<PointDTO>());
        }

        return user.getPoints();
    }

    public void add(final PointDTO point, final String username) {
        final CustomUser user = userRepository.findByLogin(username);

        if (user.getPoints() == null) {
            user.setPoints(new ArrayList<PointDTO>());
        }

        user.addPoint(point);
        userRepository.save(user);
    }
}
