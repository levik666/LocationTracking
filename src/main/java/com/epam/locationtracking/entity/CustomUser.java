package com.epam.locationtracking.entity;

import com.epam.locationtracking.dto.PointDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;
import java.util.Set;

@Document(collection = "users")
public class CustomUser{

    @Id
    private String login;
    private String password;
    private Set<GrantedAuthority> roles;

    private List<PointDTO> points;

    public CustomUser(final String login, final String password, final Set<GrantedAuthority> roles) {
        this.login = login;
        this.password = password;
        this.roles = roles;
    }

    public List<PointDTO> getPoints() {
        return points;
    }

    public void setPoints(final List<PointDTO> points) {
        this.points = points;
    }

    public void addPoint(final PointDTO point) {
        points.add(point);
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
