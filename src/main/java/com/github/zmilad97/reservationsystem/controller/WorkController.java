package com.github.zmilad97.reservationsystem.controller;

import com.github.zmilad97.reservationsystem.Service.WorkService;
import com.github.zmilad97.reservationsystem.model.Schedule;
import com.github.zmilad97.reservationsystem.model.Work;
import com.github.zmilad97.reservationsystem.repository.WorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/work/")
public class WorkController {
    private final WorkService workService;
    private final WorkRepository workRepository;

    @Autowired
    public WorkController(WorkService workService, WorkRepository workRepository) {
        this.workService = workService;
        this.workRepository = workRepository;
    }

    @PostMapping("add")
    public void addWork(@RequestBody Work work) {
        workService.save(work);
    }


    @PostMapping("update/{workId}")
    public void updateWork(@RequestBody Work work, @PathVariable long workId) {
        workService.update(workId, work);
    }

    @PostMapping("update/{id}/schedule")
    public void addSchedule(@RequestBody Schedule schedule, @PathVariable long id) {
        workService.addSchedule(schedule, id);
    }

    @PostMapping("update/{id}/information")
    public void setInformation(@RequestBody String information, @PathVariable long id) {
        workService.setInformation(information, id);
    }

    @PostMapping("update/{id}/title")
    public void setTitle(@RequestBody String title, @PathVariable long id) {
        workService.setTitle(title, id);
    }

    @PostMapping("update/{id}/status")
    public void setStatus(@RequestBody boolean status, @PathVariable long id) {
        workService.setStatus(status, id);
    }

    @GetMapping("search/{title}")
    public List<Work> search(@PathVariable String title) {
        return workRepository.findByTitleContaining(title);
    }


}
