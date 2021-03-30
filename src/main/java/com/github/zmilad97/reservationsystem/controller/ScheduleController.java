package com.github.zmilad97.reservationsystem.controller;

import com.github.zmilad97.reservationsystem.Service.ScheduleService;
import com.github.zmilad97.reservationsystem.model.Schedule;
import com.github.zmilad97.reservationsystem.repository.ScheduleRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/schedule/")
public class ScheduleController {
    private final ScheduleRepository scheduleRepository;
    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleRepository scheduleRepository, ScheduleService scheduleService) {
        this.scheduleRepository = scheduleRepository;
        this.scheduleService = scheduleService;
    }

    @PostMapping("add/{workId}")
    public void addSchedule(@RequestBody Schedule schedule, @PathVariable long workId) {
        scheduleService.save(schedule, workId);
    }

    @DeleteMapping("remove/{id}")
    public void removeSchedule(@PathVariable long id) {
        scheduleRepository.deleteById(id);
    }

    @GetMapping("weekday/{workId}/{weekDay}")
    public Map<LocalTime, LocalTime> schedulesByWeekDay(@PathVariable long workId, @PathVariable String weekDay) {
        return scheduleService.findWeekDaySchedule(workId, weekDay);
    }
}
