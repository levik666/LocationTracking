package com.epam.locationtracking.configuration;

import com.epam.locationtracking.entity.CustomUser;
import com.epam.locationtracking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(final String login) throws UsernameNotFoundException {
        final CustomUser user = userRepository.findByLogin(login);
        if (user == null){
            throw new UsernameNotFoundException("Can't find user with login " + login);
        }
        return new User(user.getLogin(), user.getPassword(), user.getRoles());
    }
}
