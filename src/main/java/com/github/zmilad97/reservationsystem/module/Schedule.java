package com.github.zmilad97.reservationsystem.module;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Map;

@Entity
public class Schedule {
    @Id
    @GeneratedValue
    private long id;

    private DayOfWeek weekDay;

    /**
     * the Map key is open session time
     * and the Map value is close session time
     * like : key =12:00  ,value = 12:15
     */
    @ElementCollection
    private Map<LocalTime, LocalTime> timeTable;

//    @ManyToOne
//    private Work work;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public DayOfWeek getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(DayOfWeek weekDay) {
        this.weekDay = weekDay;
    }

    public Map<LocalTime, LocalTime> getTimeTable() {
        return timeTable;
    }

    public void setTimeTable(Map<LocalTime, LocalTime> timeTable) {
        this.timeTable = timeTable;
    }

    public void addTime(LocalTime key, LocalTime value) {

        this.timeTable.put(key, value);

    }

}
