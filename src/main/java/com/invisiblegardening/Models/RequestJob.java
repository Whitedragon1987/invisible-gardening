package com.invisiblegardening.Models;

import javax.persistence.*;

@Entity
public class RequestJob {

        @EmbeddedId
        private RequestJobKey id;

        @ManyToOne
        @MapsId("requestId")
        @JoinColumn(name = "request_id")
        private Request request;

        @ManyToOne
        @MapsId("jobId")
        @JoinColumn(name = "job_id")
        private Job job;

        public RequestJobKey getId() {
                return id;
        }

        public Request getRequest() {
                return request;
        }

        public Job getJob() {
                return job;
        }

        public void setId(RequestJobKey id) {
                this.id = id;
        }

        public void setRequest(Request request) {
                this.request = request;
        }

        public void setJob(Job job) {
                this.job = job;
        }
}
