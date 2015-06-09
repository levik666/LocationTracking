package com.epam.locationtracking.service;

import com.epam.locationtracking.entity.CustomUser;

public interface UserService {

    CustomUser findByLogin(String login);
}
