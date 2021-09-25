package com.invisiblegardening.Models;

import javax.persistence.*;

@Entity
public class RequestMachine {

    @EmbeddedId
    private RequestMachineKey id;

    @ManyToOne
    @MapsId("requestId")
    @JoinColumn(name = "request_id")
    private Request request;

    @ManyToOne
    @MapsId("machineId")
    @JoinColumn(name = "machine_id")
    private Machine machine;

    public RequestMachineKey getId() {
        return id;
    }

    public Request getRequest() {
        return request;
    }

    public Machine getMachine() {
        return machine;
    }

    public void setId(RequestMachineKey id) {
        this.id = id;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }
}
