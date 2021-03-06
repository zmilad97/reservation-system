package com.github.zmilad97.reservationsystem.controller;

import com.github.zmilad97.reservationsystem.security.SecurityUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class HomeController {
    @GetMapping("/test")
    public String test(Principal principal) {
        return principal.getName();
    }

    @GetMapping("/test2")
    public String test2() {
        return "Done Test 2";
    }
}
