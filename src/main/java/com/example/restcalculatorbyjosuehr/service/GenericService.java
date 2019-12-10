package com.example.restcalculatorbyjosuehr.service;
import com.example.restcalculatorbyjosuehr.model.User;
import java.util.List;

public interface GenericService {
    /**
     *
     * @param username
     * @return User Entity
     */
    User findByUsername(String username);

    /**
     *
     * @return List of user entities
     */
    List<User> findAllUsers();
}