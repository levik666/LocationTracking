package com.epam.locationtracking.repository;

import com.epam.locationtracking.entity.CustomUser;
import com.epam.locationtracking.service.UserService;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<CustomUser, String>, UserService {

    CustomUser findByLogin(String login);
}
