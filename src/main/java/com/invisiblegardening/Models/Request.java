package com.invisiblegardening.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;


@Entity
public class Request {

    @Id
    @GeneratedValue
    Long id;

    LocalDateTime requestStartTime;
    LocalDateTime requestEndTime;
    LocalDateTime confirmedStartTime;
    LocalDateTime confirmedEndTime;

    Status status;

    @ManyToOne
    UserData userData;

    // (fetch= FetchType.EAGER) werkt niet met meerdere in een entiteit door bug in Hibernate
    @OneToMany(mappedBy = "request")
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonIgnore
    Collection<RequestMachine> requestMachines;

    @OneToMany(mappedBy = "request")
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonIgnore
    Collection<RequestJob> requestJobs;
    

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

    public Status getStatus() {
        return status;
    }

    public Collection<RequestJob> getRequestJobs() {
        return requestJobs;
    }

    public Collection<RequestMachine> getRequestMachines() {
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

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setRequestMachines(Collection<RequestMachine> requestMachines) {
        this.requestMachines = requestMachines;
    }

    public void setRequestJobs(Collection<RequestJob> requestJobs) {
        this.requestJobs = requestJobs;
    }

}
