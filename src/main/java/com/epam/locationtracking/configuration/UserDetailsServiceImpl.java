package com.epam.locationtracking.configuration;

import com.epam.locationtracking.model.CustomUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
        final CustomUser user = getUserByEmail(email);
        return new User(user.getLogin(), user.getPassword(), user.getRoles());
    }

    private CustomUser getUserByEmail(final String email){
        final CustomUser user = new CustomUser();
        user.setLogin(email);
        user.setPassword("b3daa77b4c04a9551b8781d03191fe098f325e67");
        return user;
    }
}
