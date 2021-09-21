package com.invisiblegardening.Models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

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

    @ManyToMany(mappedBy= "requestList")
    Set<Machine> machineIdList = new HashSet<>();

    @ManyToMany(mappedBy = "requestList")
    Set<Job> jobIdList = new HashSet<>();

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

    public Set<Machine> getMachineIdList() {
        return machineIdList;
    }

    public Set<Job> getJobIdList() {
        return jobIdList;
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

    public void setMachineIdList(HashSet<Machine> machines) {
        this.machineIdList = machines;
    }

    public void setJobIdList(HashSet<Job> jobs) {
        this.jobIdList = jobs;
    }
}
