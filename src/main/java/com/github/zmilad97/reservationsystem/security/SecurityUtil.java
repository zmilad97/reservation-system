package com.github.zmilad97.reservationsystem.security;

import com.github.zmilad97.reservationsystem.module.User;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtil {

    public static User getCurrentUser(){
        return ((UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser();
    }

}
