package com.github.zmilad97.reservationsystem.starter;

import com.github.zmilad97.reservationsystem.module.User;
import com.github.zmilad97.reservationsystem.repository.UserRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class systemStarter implements ApplicationRunner {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public systemStarter(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (userRepository.findUserById(1) == null)
            userRepository.save(adminUser());
    }


    public User adminUser() {
        User user = new User();
        user.setId(1);
        user.setPhonenumber(Long.parseLong("09389717356"));
        user.setPassword(passwordEncoder.encode("admin"));
        user.setEmail("admin@gmail.com");
        user.setGender(User.Gender.MALE);
        user.setRoles("ADMIN");
        user.setActive(true);
        return user;
    }
}
