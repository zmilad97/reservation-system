package com.github.zmilad97.reservationsystem.controller;

import com.github.zmilad97.reservationsystem.Service.ScheduleService;
import com.github.zmilad97.reservationsystem.module.Schedule;
import com.github.zmilad97.reservationsystem.repository.ScheduleRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedule/")
public class ScheduleController {
    private final ScheduleRepository scheduleRepository;
    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleRepository scheduleRepository, ScheduleService scheduleService) {
        this.scheduleRepository = scheduleRepository;
        this.scheduleService = scheduleService;
    }

    @PostMapping("add")
    public void addSchedule(@RequestBody Schedule schedule) {
        scheduleRepository.save(schedule);
    }

    @DeleteMapping("remove/{id}")
    public void removeSchedule(@PathVariable long id) {
        scheduleRepository.deleteById(id);
    }

    @GetMapping("weekday/{workId}/{weekDay}")
    public List<Schedule> schedulesByWeekDay(@PathVariable long workId, @PathVariable String weekDay) {
        return scheduleService.findWeekDaySchedule(workId, weekDay);
    }


}
