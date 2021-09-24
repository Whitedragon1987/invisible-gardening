package com.invisiblegardening.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @OneToMany(mappedBy = "request")
    @JsonIgnore
    Set<RequestMachine> requestMachines;

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

    public Set<Job> getJobIdList() {
        return jobIdList;
    }

    public Set<RequestMachine> getRequestMachines() {
        return requestMachines;
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

    public void setRequestMachines(Set<RequestMachine> requestMachines) {
        this.requestMachines = requestMachines;
    }

    public void setJobIdList(HashSet<Job> jobs) {
        this.jobIdList = jobs;
    }
}
