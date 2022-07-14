package com.s1mob.testoffer.controller;

import com.s1mob.testoffer.model.User;
import com.s1mob.testoffer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/users")
public class UserController {
    private UserService userService;

    @GetMapping("/{userName}")
    public ResponseEntity<User> getRegisteredUserByUserName(@PathVariable String userName) {
        User registeredUser = userService.getRegisteredUser(userName);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody final User user) throws Exception {
        User registeredUser = userService.saveUser(user);
        return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
