package com.bitsbids.BITSBids.service;


import com.bitsbids.BITSBids.model.User;
import com.bitsbids.BITSBids.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private MyUserDetailsService myUserDetailsService;

    public User findCurrentUser(String email) {
        return userRepo.findByEmail(email);
    }
    public List<User> findAllUsers(){
        return userRepo.findAll();
    }

    public User registerUser(String name,String username, String email, String password) {
        return myUserDetailsService.addUser(name,username, email, password);
    }
}
