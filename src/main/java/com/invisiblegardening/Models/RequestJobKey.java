package com.invisiblegardening.Models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RequestJobKey implements Serializable {


    @Column(name = "request_id")
    private Long requestId;

    @Column(name = "job_id")
    private Long jobId;

    public RequestJobKey() { }
    public RequestJobKey(Long requestId, Long jobId) {
        this.requestId = requestId;
        this.jobId = jobId;
    }

    public Long getRequestId() {
        return requestId;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        com.invisiblegardening.Models.RequestJobKey that = (com.invisiblegardening.Models.RequestJobKey) o;
        return requestId.equals(that.requestId)&& jobId.equals(that.jobId);
    }

    @Override
    public int hashCode() {return Objects.hash(requestId, jobId);}


}
