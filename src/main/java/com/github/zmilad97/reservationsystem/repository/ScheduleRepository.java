package com.github.zmilad97.reservationsystem.repository;

import com.github.zmilad97.reservationsystem.module.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

}
