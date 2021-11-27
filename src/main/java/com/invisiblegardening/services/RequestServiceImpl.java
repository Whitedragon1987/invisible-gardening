package com.invisiblegardening.services;

import com.invisiblegardening.Exceptions.BadRequestException;
import com.invisiblegardening.Exceptions.RecordNotFoundException;
import com.invisiblegardening.Models.*;
import com.invisiblegardening.controllers.dtos.RequestInputDto;
import com.invisiblegardening.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Service
public class RequestServiceImpl implements RequestService{
    private final RequestRepository requestRepository;
    private final UserDataRepository userDataRepository;
    private final RequestMachineRepository requestMachineRepository;
    private final RequestJobRepository requestJobRepository;


    @Autowired
    public RequestServiceImpl(RequestRepository requestRepository,

                              UserDataRepository userDataRepository,

                              RequestMachineRepository requestMachineRepository,

                              RequestJobRepository requestJobRepository){

        this.requestRepository = requestRepository;

        this.userDataRepository = userDataRepository;

        this.requestMachineRepository = requestMachineRepository;

        this.requestJobRepository = requestJobRepository;

    }

    @Override
    public List<Request> getRequests() {

        return requestRepository.findAll();

    }

    @Override
    @Transactional
    public Request getRequest(Long id) {

        var optionalRequest = requestRepository.findById(id);

        if (optionalRequest.isEmpty()) {

            throw new RecordNotFoundException("no request was found");

        } else {

            return optionalRequest.get();

        }

    }

    @Override
    @Transactional
    public Long planRequest(Collection<Long> machineIdList, Collection<Long> jobIdList, Long userDataId, LocalDateTime requestStartTime, LocalDateTime requestEndTime) {

        var optionalUserData = userDataRepository.findById(userDataId);

        var userData = optionalUserData.get();

        var request = new Request();

        request.setUserData(userData);

        request.setRequestStartTime(requestStartTime);

        request.setRequestEndTime(requestEndTime);

        request.setStatus(Status.PLANNED);

        requestRepository.save(request);

        var requestId = request.getId();

        request.setRequestMachines(requestMachineRepository.findAllByRequestId(requestId));

        request.setRequestJobs(requestJobRepository.findAllByRequestId(requestId));

        if (optionalUserData.isEmpty() || (machineIdList.isEmpty() && jobIdList.isEmpty() )) {

            throw new BadRequestException("missing information");

        }

        return requestId;

    }

    @Override
    public Request updateRequest(Long id, RequestInputDto dto) {

        var request = requestRepository.findById(id).get();

        request.setUserData(request.getUserData());

        request.setId(request.getId());

        request.setRequestStartTime(request.getRequestStartTime());

        request.setRequestEndTime(request.getRequestEndTime());

        request.setConfirmedStartTime(dto.confirmedStartTime);

        request.setConfirmedEndTime(dto.confirmedEndTime);

        request.setStatus(dto.status);

        requestRepository.save(request);

        request.setRequestMachines(requestMachineRepository.findAllByRequestId(request.getId()));

        request.setRequestJobs(requestJobRepository.findAllByRequestId(request.getId()));

        return request;

    }

}
