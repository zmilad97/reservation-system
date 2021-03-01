package com.github.zmilad97.reservationsystem.Service;

import com.github.zmilad97.reservationsystem.model.Schedule;
import com.github.zmilad97.reservationsystem.model.Work;
import com.github.zmilad97.reservationsystem.repository.ScheduleRepository;
import com.github.zmilad97.reservationsystem.repository.WorkRepository;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final WorkRepository workRepository;

    public ScheduleService(ScheduleRepository scheduleRepository, WorkRepository workRepository) {
        this.scheduleRepository = scheduleRepository;
        this.workRepository = workRepository;
    }

    public List<Schedule> findWeekDaySchedule(long workId, String weekDay) {
        DayOfWeek dayOfWeek = DayOfWeek.valueOf(weekDay);
        Work work = workRepository.findWorkById(workId);
        return work.getSchedule().stream().filter(
                schedule -> schedule.getWeekDay().equals(dayOfWeek)).collect(Collectors.toList());

    }


}
