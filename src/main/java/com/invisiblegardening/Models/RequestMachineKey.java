package com.invisiblegardening.Models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RequestMachineKey implements Serializable {

    @Column(name = "request_id")
    private Long requestId;

    @Column(name = "machine_id")
    private Long machineId;

    public RequestMachineKey() { }
    public RequestMachineKey(Long requestId, Long machineId) {
        this.requestId = requestId;
        this.machineId = machineId;
    }

    public Long getRequestId() {
        return requestId;
    }

    public Long getMachineId() {
        return machineId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    public void setMachineId(Long machineId) {
        this.machineId = machineId;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        RequestMachineKey that = (RequestMachineKey) o;
        return requestId.equals(that.requestId)&& machineId.equals(that.machineId);
    }

    @Override
    public int hashCode() {return Objects.hash(requestId, machineId);}
}
