package com.github.zmilad97.reservationsystem.starter;

import com.github.zmilad97.reservationsystem.model.User;
import com.github.zmilad97.reservationsystem.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class SystemStarter implements ApplicationRunner {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private static final Logger LOG = LoggerFactory.getLogger(SystemStarter.class);

    public SystemStarter(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (userRepository.findByPhonenumber(Long.parseLong("09389717356")) == null){
            userRepository.save(adminUser());
            LOG.info("admin user created");
        }

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
