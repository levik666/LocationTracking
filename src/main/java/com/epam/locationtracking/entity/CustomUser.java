package com.epam.locationtracking.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;

import java.util.Set;

@Document(collection = "users")
public class CustomUser{

    @Id
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
        return roles;
    }

    public void setRoles(Set<GrantedAuthority> roles) {
        this.roles = roles;
    }
}
