package com.epam.locationtracking.configuration;

import com.epam.locationtracking.entity.CustomUser;
import com.epam.locationtracking.service.SocialTypeService;
import com.epam.locationtracking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private static final String SOCIAL_TYPE = "socialType";

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private SocialTypeService socialTypeService;

    @Autowired
    private List<UserService> userServices;

    @Override
    public UserDetails loadUserByUsername(final String login) throws UsernameNotFoundException {
        final String socialType = request.getHeader(SOCIAL_TYPE);
        final UserService userService = socialTypeService.getUserServiceByType(socialType, userServices);

        if (userService == null) {
            throw new UsernameNotFoundException("Can't find social type with login " + login + ", " + socialType);
        }

        final CustomUser user = userService.findByLogin(login);

        if (user == null){
            throw new UsernameNotFoundException("Can't find user with login " + login);
        }

        return new User(user.getLogin(), user.getPassword(), user.getRoles());
    }
}
