package com.example.restcalculatorbyjosuehr.service.impl;
import com.example.restcalculatorbyjosuehr.model.User;
import com.example.restcalculatorbyjosuehr.repository.UserRepository;
import com.example.restcalculatorbyjosuehr.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GenericServiceImpl implements GenericService {
    @Autowired
    private UserRepository userRepository;

    /**
     *
     * @param username
     * @return User Entity
     */
    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    /**
     *
     * @return List of user entities
     */
    @Override
    public List<User> findAllUsers() {
        return (List<User>)userRepository.findAll();
    }
}
