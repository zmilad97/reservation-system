package com.github.zmilad97.reservationsystem.controller;

import com.github.zmilad97.reservationsystem.Service.UserService;
import com.github.zmilad97.reservationsystem.module.User;
import com.github.zmilad97.reservationsystem.security.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("add")
    public void addUser(@RequestBody User user) {
        userService.saveUser(user);
    }

    @GetMapping("current")
    public User currentUser() {
        return SecurityUtil.getCurrentUser();
    }
}
