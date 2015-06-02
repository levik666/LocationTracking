package com.epam.locationtracking.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.HashSet;
import java.util.Set;

public class CustomUser{

    private String login;
    private String password;
    private Set<GrantedAuthority> roles;

    public CustomUser(final String login, final String password, final Set<GrantedAuthority> roles) {
        this.login = login;
        this.password = password;
        this.roles = roles;
    }

    public CustomUser() {}

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<GrantedAuthority> getRoles() {
        if (roles == null || roles.isEmpty()){
            roles = defaultUserRole();
        }
        return roles;
    }

    private Set<GrantedAuthority> defaultUserRole(){
        final Set<GrantedAuthority> roles = new HashSet<>();
        roles.add(new SimpleGrantedAuthority(UserRoles.USER.name()));
        return roles;
    }

    public void setRoles(Set<GrantedAuthority> roles) {
        this.roles = roles;
    }
}
