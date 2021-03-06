package com.github.zmilad97.reservationsystem.security;

import com.github.zmilad97.reservationsystem.model.User;
import com.github.zmilad97.reservationsystem.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;

import java.security.Principal;

public class SecurityUtil {
    public static User user;
    private static  UserRepository userRepository  ;
 public static Principal principal ;
    public static User getCurrentUser(){
//        return userRepository.findByPhonenumber()
        return user;
//        return ((UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser();
    }

//    public static String getUsername(){
//        return ((UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
//    }

}
