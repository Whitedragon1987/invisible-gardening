package com.invisiblegardening.controllers;

import com.invisiblegardening.Models.Request;
import com.invisiblegardening.controllers.dtos.RequestDto;
import com.invisiblegardening.controllers.dtos.RequestInputDto;
import com.invisiblegardening.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("requests")
public class RequestController {
    private final RequestService requestService;
    private final RequestMachineService requestMachineService;
    private final RequestJobService requestJobService;


    @Autowired
    public RequestController(RequestService requestService,
                             RequestMachineService requestMachineService,
                             RequestJobService requestJobService) {

        this.requestService = requestService;
        this.requestMachineService = requestMachineService;
        this.requestJobService = requestJobService;

    }

    @GetMapping
    public List<RequestDto> getRequests() {

        var dtos = new ArrayList<RequestDto>();

        var requests = requestService.getRequests();


        for (Request request : requests) {

            dtos.add(RequestDto.fromRequest(request));

        }

        return dtos;
    }

    @GetMapping("/{id}")
    public RequestDto getRequest(@PathVariable("id") Long id) {
        var request = requestService.getRequest(id);
        return RequestDto.fromRequest(request);
    }

    @PostMapping
    public void saveRequest(@RequestBody RequestInputDto dto) {

        var requestId = requestService.planRequest(dto.machineIdList, dto.jobIdList, dto.userDataId, dto.requestStartTime, dto.requestEndTime);

        for (Long machineId : dto.machineIdList) {

            requestMachineService.addRequestMachine(requestId, machineId);

        }

        for (Long jobId : dto.jobIdList) {

            requestJobService.addRequestJob(requestId, jobId);

        }


    }

    @PutMapping("/{id}")
    public RequestDto updateRequest(@PathVariable("id") Long id, @RequestBody RequestInputDto dto) {

        requestService.updateRequest(id, dto);
        var request = requestService.getRequest(id);

        return RequestDto.fromRequest(request);
    }

}
