package com.github.zmilad97.reservationsystem.security;

import com.github.zmilad97.reservationsystem.module.User;
import com.github.zmilad97.reservationsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByPhonenumber(Long.parseLong(s));
        if(user == null)
            throw new UsernameNotFoundException("Error 404");
        return new UserPrincipal(user);
    }
}
