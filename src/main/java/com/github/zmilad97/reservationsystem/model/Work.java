package com.github.zmilad97.reservationsystem.model;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.*;


@Entity
public class Work {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String title;

    @ManyToOne
    private User owner;

    @OneToMany
    private Set<Schedule> schedule;

    private String information;

    private boolean isOpen;


    public Work() {
        this.isOpen = true;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public Set<Schedule> getSchedule() {
        return schedule;
    }

    public void setSchedule(Set<Schedule> schedule) {
        this.schedule = schedule;
    }

    public void addSchedule(Schedule schedule) {
        if (this.schedule == null)
            this.schedule = new HashSet<>();
        this.schedule.add(schedule);
    }

    public Map<DayOfWeek, Schedule> getScheduleMap() {
        Map<DayOfWeek, Schedule> scheduleMap = new HashMap<>();
        this.schedule.forEach(s -> scheduleMap.put(s.getWeekDay(), s));
        return scheduleMap;
    }

    /**
     * this method gets a name of a weekday
     * as parameter then returns timeTable of
     * the day in a map structure
     */
    public Map<LocalTime, LocalTime> getScheduleTimeTableMapOfDay(DayOfWeek weekDay) {

        Map<LocalTime, LocalTime> timeTable = new HashMap<>();
        this.schedule.forEach(s -> {
            if (s.getWeekDay().equals(weekDay))
                timeTable.putAll(s.getTimeTable());
        });
        return timeTable;
    }

}
