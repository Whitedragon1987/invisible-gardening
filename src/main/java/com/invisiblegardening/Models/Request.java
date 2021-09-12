package com.invisiblegardening.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class Request {

    @Id
    @GeneratedValue
    Long id;

    LocalDateTime requestStartTime;
    LocalDateTime requestEndTime;
    LocalDateTime confirmedStartTime;
    LocalDateTime confirmedEndTime;

    RequestStatus status;

    @ManyToOne
    UserData userData;

    @ManyToOne
    Machine machine;

    @ManyToOne
    Job job;

    public Long getId() {

        return id;

    }

    public LocalDateTime getRequestStartTime() {

        return requestStartTime;

    }

    public LocalDateTime getRequestEndTime() {

        return requestEndTime;

    }

    public UserData getUserData() {

        return userData;

    }

    public LocalDateTime getConfirmedStartTime() {

        return confirmedStartTime;

    }

    public LocalDateTime getConfirmedEndTime() {

        return confirmedEndTime;

    }

    public RequestStatus getStatus() {

        return status;

    }

    public Machine getMachine() {

        return machine;

    }

    public Job getJob() {

        return job;

    }

    public void setId(Long id) {

        this.id = id;

    }

    public void setRequestStartTime(LocalDateTime requestStartTime) {

        this.requestStartTime = requestStartTime;

    }

    public void setRequestEndTime(LocalDateTime requestEndTime) {

        this.requestEndTime = requestEndTime;

    }

    public void setUserData(UserData userData) {

        this.userData = userData;

    }

    public void setConfirmedStartTime(LocalDateTime confirmedStartTime) {

        this.confirmedStartTime = confirmedStartTime;

    }

    public void setConfirmedEndTime(LocalDateTime getConfirmedEndTime) {

        this.confirmedEndTime = getConfirmedEndTime;

    }

    public void setStatus(RequestStatus status) {

        this.status = status;

    }

    public void setMachine(Machine machine) {

        this.machine = machine;

    }

    public void setJob(Job job) {

        this.job = job;

    }

}
