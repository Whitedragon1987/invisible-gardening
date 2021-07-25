package com.invisiblegardening.controllers;

import com.invisiblegardening.Exceptions.BadRequestException;
import com.invisiblegardening.Models.Request;
import com.invisiblegardening.controllers.dtos.RequestDto;
import com.invisiblegardening.controllers.dtos.RequestInputDto;
import com.invisiblegardening.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("requests")
public class RequestController {
    private final RequestService requestService;

    @Autowired
    public RequestController(RequestService requestService) {

        this.requestService = requestService;
    }

    @GetMapping
    public List<RequestDto> getRequests(@RequestParam(value = "machineId", required = false) Long machineId,
                                        @RequestParam(value = "jobId", required = false) Long jobId,
                                        @RequestParam(value = "customerDataId", required = false) Long userDataId,
                                        @RequestParam(value = "quoteId", required = false) Long quoteId,
                                        @RequestParam(value = "start", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
                                        @RequestParam(value = "end", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {

        var dtos = new ArrayList<RequestDto>();

        List<Request> requests;

        if (machineId == null && jobId == null && userDataId == null && quoteId == null && start == null && end == null) {

            requests = requestService.getRequests();

        } else if (machineId != null && jobId == null && quoteId == null && userDataId == null && start == null && end == null) {

            requests = requestService.getRequestsForMachine(machineId);

        } else if (jobId != null && userDataId == null && machineId == null && quoteId == null && start == null && end == null) {

           requests = requestService.getRequestsForJob(jobId);

        } else if (userDataId != null && jobId == null && machineId == null && quoteId == null && start == null && end == null) {

            requests = requestService.getRequestsForUserData(userDataId);

        }
        else if (userDataId == null && jobId == null && machineId == null && quoteId != null && start == null && end == null) {

            requests = requestService.getRequestsForQuote(quoteId);

        } else if (start != null && end != null && userDataId == null && quoteId == null && jobId == null && machineId == null) {

            requests = requestService.getRequestBetweenDates(start, end);

        } else {

            throw new BadRequestException();
        }

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

        requestService.planRequest(dto.machineId, dto.jobId, dto.userDataId, dto.quoteId, dto.startTime, dto.endTime);

    }

}
