package com.epam.locationtracking.facades;

import com.epam.locationtracking.dto.UserDTO;
import com.epam.locationtracking.entity.CustomUser;
import com.epam.locationtracking.entity.UserRoles;
import com.epam.locationtracking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RegistrationFacades {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registration(final UserDTO user){
        final String encodePassword = passwordEncoder.encode(user.getPassword());
        final CustomUser customUser = new CustomUser(user.getLogin(), encodePassword, getRoles());
        userRepository.save(customUser);
    }

    private Set<GrantedAuthority> getRoles(){
        final Set<GrantedAuthority> roles = new HashSet<>();
        roles.add(new SimpleGrantedAuthority(UserRoles.ROLE_USER.name()));
        return roles;
    }
}
