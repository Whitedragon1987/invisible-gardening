package com.invisiblegardening.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Job {

    @Id
    @GeneratedValue
    Long id;

    String jobName;
    String jobDescription;
    Boolean employeeNeeded;

    @OneToOne
    Picture picture;

    @ManyToOne
    Employee employee;

    @OneToMany(mappedBy = "request")
    @JsonIgnore
    List<RequestJob> requestJobs;

    public Long getId() {

        return id;

    }

    public String getJobName() {

        return jobName;

    }

    public String getJobDescription() {

        return jobDescription;

    }

    public Boolean getEmployeeNeeded() {

        return employeeNeeded;

    }

    public Employee getEmployee() {
        return employee;
    }

    public Picture getPicture() {
        return picture;
    }

    public List<RequestJob> getRequestJobs() {
        return requestJobs;
    }

    public void setId(Long id) {

        this.id = id;

    }

    public void setJobName(String jobName) {

        this.jobName = jobName;

    }

    public void setJobDescription(String jobDescription) {

        this.jobDescription = jobDescription;

    }

    public void setEmployeeNeeded(Boolean employeeNeeded) {

        this.employeeNeeded = employeeNeeded;

    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public void setRequestJobs(List<RequestJob> requestJobs) {
        this.requestJobs = requestJobs;
    }
}
