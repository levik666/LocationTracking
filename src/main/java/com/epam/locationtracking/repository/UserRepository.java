package com.epam.locationtracking.repository;

import com.epam.locationtracking.entity.CustomUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<CustomUser, Long>{

    CustomUser findByLogin(String login);
}
