package com.invisiblegardening.services;

import com.invisiblegardening.Models.Request;
import com.invisiblegardening.controllers.dtos.RequestInputDto;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

public interface RequestService {

    List<Request> getRequests();

    Request getRequest(Long requestId);

    Long planRequest(Collection<Long> machineIdList, Collection<Long> jobIdList, Long userDataId, LocalDateTime requestStartTime, LocalDateTime requestEndTime);

    Request updateRequest(Long id, RequestInputDto dto);

}
