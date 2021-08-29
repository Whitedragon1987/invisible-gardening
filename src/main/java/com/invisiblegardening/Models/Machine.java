package com.invisiblegardening.Models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Machine {

    @Id
    @GeneratedValue
    Long id;

    String machineName;
    String machineDescription;
    String machineType;
    String machineMeasurements;
    Date machineLastService;
    Date machinePlannedService;

    @OneToOne
    Picture picture;

    @OneToMany(mappedBy = "machine")
    List<Request> requestList;

    public Long getId() {

        return id;

    }

    public String getMachineName() {

        return machineName;

    }

    public String getMachineDescription() {

        return machineDescription;

    }

    public String getMachineType() {

        return machineType;

    }

    public String getMachineMeasurements() {

        return machineMeasurements;

    }

    public Date getMachineLastService() {

        return machineLastService;

    }

    public Date getMachinePlannedService() {

        return machinePlannedService;

    }

    public Picture getPicture() {
        return picture;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMachineName(String machineName) {

        this.machineName = machineName;

    }

    public void setMachineDescription(String machineDescription) {

        this.machineDescription = machineDescription;

    }

    public void setMachineType(String machineType) {

        this.machineType = machineType;

    }

    public void setMachineMeasurements(String machineMeasurements) {

        this.machineMeasurements = machineMeasurements;

    }

    public void setMachineLastService(Date machineLastService) {

        this.machineLastService = machineLastService;

    }

    public void setMachinePlannedService(Date machinePlannedService) {

        this.machinePlannedService = machinePlannedService;

    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }
}
