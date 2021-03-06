package com.github.zmilad97.reservationsystem.repository;

import com.github.zmilad97.reservationsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
      User findByPhonenumber(String phonenumber);
      User findUserById(long id);
}
