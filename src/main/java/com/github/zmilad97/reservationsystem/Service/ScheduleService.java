package com.github.zmilad97.reservationsystem.Service;

import com.github.zmilad97.reservationsystem.model.Schedule;
import com.github.zmilad97.reservationsystem.model.Work;
import com.github.zmilad97.reservationsystem.repository.ScheduleRepository;
import com.github.zmilad97.reservationsystem.repository.WorkRepository;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final WorkRepository workRepository;

    public ScheduleService(ScheduleRepository scheduleRepository, WorkRepository workRepository) {
        this.scheduleRepository = scheduleRepository;
        this.workRepository = workRepository;
    }

    public void save(Schedule schedule, long workId) {
        scheduleRepository.save(schedule);
        Work work = workRepository.findWorkById(workId);
        work.getSchedule().forEach(s -> {
            if (s.getWeekDay() == schedule.getWeekDay())
                work.getSchedule().remove(s);
        });
        work.addSchedule(schedule);
        workRepository.save(work);
    }

    public Map<LocalTime, LocalTime> findWeekDaySchedule(long workId, String weekDay) {
        Map<LocalTime, LocalTime> timeTable;
        DayOfWeek dayOfWeek = DayOfWeek.valueOf(weekDay);
        Work work = workRepository.findWorkById(workId);
        timeTable = work.getSchedule().stream()
                .filter(schedule -> schedule.getWeekDay().equals(dayOfWeek))
                .collect(Collectors.toList()).get(0).getTimeTable();
        return timeTable;
    }


}
