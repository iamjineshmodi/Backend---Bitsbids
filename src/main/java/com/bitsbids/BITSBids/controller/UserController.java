package com.bitsbids.BITSBids.controller;

import com.bitsbids.BITSBids.model.User;
import com.bitsbids.BITSBids.service.UserService;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeTokenRequest;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import static org.springframework.security.web.context.HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    UserService userService;

//    @Resource(name="authenticationManager")
//    private AuthenticationManager authManager;


    /*@PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user, HttpServletRequest req) {
        securityLogin(user.getEmail(), user.getPassword(), req);
        return ResponseEntity.ok("ok");
    }*/

    @GetMapping("/currentuser")
    public ResponseEntity<User> currentUser(@RequestParam String email) {
        User user = userService.findCurrentUser(email);
        if(user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(user);
    }

    @GetMapping("/auth/user")
    public User getUser(@RequestParam String email){
        return userService.findCurrentUser(email);
    }
    @GetMapping("/auth/users")
    public List<User> getUsers(){return userService.findAllUsers();};

    @PostMapping("/auth/register")
    public ResponseEntity<User> register(@RequestBody User user){
        var newuser = userService.registerUser(user.getName(), user.getUsername(),user.getEmail(), user.getPassword());
        return ResponseEntity.ok(newuser);
    }

//    private void securityLogin(String email, String password, HttpServletRequest req) {
//        UsernamePasswordAuthenticationToken authReq
//                = new UsernamePasswordAuthenticationToken(email, password);
////        Authentication auth = authManager.authenticate(authReq);
//
//        SecurityContext sc = SecurityContextHolder.getContext();
////        sc.setAuthentication(auth);
//        HttpSession session = req.getSession(true);
//        session.setAttribute(SPRING_SECURITY_CONTEXT_KEY, sc);
//    }

}
