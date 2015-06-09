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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserFacades {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registration(final UserDTO user){
        final String encodePassword = passwordEncoder.encode(user.getPassword());
        final CustomUser customUser = new CustomUser(user.getLogin(), encodePassword, getRoles());
        userRepository.save(customUser);
    }

    public void updateUser(UserDTO userDTO, final String username){
        final CustomUser user = userRepository.findByLogin(username);
        user.setPassword(userDTO.getPassword());
        userRepository.save(user);
    }

    public List<String> getUsers(){
        final List<CustomUser> customers = userRepository.findAll();
        final List<String> users = new ArrayList<>(customers.size());

        for(final CustomUser customer :  customers){
            users.add(customer.getLogin());
        }

        return users;
    }

    private Set<GrantedAuthority> getRoles(){
        final Set<GrantedAuthority> roles = new HashSet<>();
        roles.add(new SimpleGrantedAuthority(UserRoles.ROLE_USER.name()));
        return roles;
    }

    public void delete(final String username) {
        userRepository.delete(username);
    }

    public String getUser(final String username) {
        final CustomUser user = userRepository.findOne(username);
        return user.getLogin();
    }
}
