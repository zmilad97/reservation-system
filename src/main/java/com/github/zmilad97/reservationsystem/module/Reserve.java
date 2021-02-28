package com.github.zmilad97.reservationsystem.module;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Reserve {

    @Id
    @GeneratedValue
    private long id;
    /**
     * it is where the user wants a reservation
     */
    @ManyToOne
    private Work work;
    /**
     * the user wants a reservation
     */
    @ManyToOne
    private User user;

    /**
     * reserved date  (mm-dd-yyyy)
     * it should save like : 03-14-2021
     */
    private LocalDate date;
    /**
     * reserved time
     * it should save like : 12:50
     */
    private LocalTime time;

    /**
     * if owner of the job approved the reservation
     * this parameter will be true
     */
    private boolean approved;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

}
