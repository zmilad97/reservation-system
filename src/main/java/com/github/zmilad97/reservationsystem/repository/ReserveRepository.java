package com.github.zmilad97.reservationsystem.repository;

import com.github.zmilad97.reservationsystem.module.Reserve;
import com.github.zmilad97.reservationsystem.module.User;
import com.github.zmilad97.reservationsystem.module.Work;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReserveRepository extends JpaRepository<Reserve, Long> {
    Reserve findReserveById(long id);
    List<Reserve> findByUser(User user);
    List<Reserve> findReserveByWork(Work work);
}
