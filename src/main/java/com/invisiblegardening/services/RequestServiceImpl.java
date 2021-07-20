package com.invisiblegardening.services;

import com.invisiblegardening.Exceptions.BadRequestException;
import com.invisiblegardening.Exceptions.RecordNotFoundException;
import com.invisiblegardening.Models.Job;
import com.invisiblegardening.Models.Machine;
import com.invisiblegardening.Models.Request;
import com.invisiblegardening.Models.RequestStatus;
import com.invisiblegardening.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RequestServiceImpl implements RequestService {
    private RequestRepository requestRepository;
    private UserDataRepository userDataRepository;
    private MachineRepository machineRepository;
    private JobRepository jobRepository;
    private QuoteRepository quoteRepository;

    @Autowired
    public RequestServiceImpl(RequestRepository requestRepository,

                              UserDataRepository userDataRepository,

                              MachineRepository machineRepository,

                              JobRepository jobRepository,

                              QuoteRepository quoteRepository){

        this.requestRepository = requestRepository;

        this.userDataRepository = userDataRepository;

        this.machineRepository = machineRepository;

        this.jobRepository = jobRepository;

        this.quoteRepository = quoteRepository;

    }

    @Override
    public List<Request> getRequests() {

        return requestRepository.findAll();

    }

    @Override
    public List<Request> getRequestBetweenDates(LocalDateTime start, LocalDateTime end) {

        return requestRepository.findByRequestStartTimeBetween(start, end);

    }

    @Override
    public List<Request> getRequestsForMachine(Long machineId) {

        var optionalMachine = machineRepository.findById(machineId);

        if (optionalMachine.isPresent()) {

            var machine = optionalMachine.get();

            return requestRepository.findByMachine(machine);

        } else {

            throw new RecordNotFoundException("no requests for machine");

        }

    }

    @Override
    public List<Request> getRequestsForJob(Long jobId) {

        var optionalJob = jobRepository.findById(jobId);

        if (optionalJob.isPresent()) {

            var job = optionalJob.get();

            return requestRepository.findByJob(job);

        } else {

            throw new RecordNotFoundException("no requests for job");

        }

    }

    @Override
    public List<Request> getRequestsForUserData(Long userDataId) {

        var optionalUserData = userDataRepository.findById(userDataId);

        if (optionalUserData.isPresent()) {

            var userData = optionalUserData.get();

            return requestRepository.findByUserData(userData);

        } else {

            throw new RecordNotFoundException("no requests for user");

        }

    }

    @Override
    public List<Request> getRequestsForQuote(Long quoteId) {

        var optionalQuote = quoteRepository.findById(quoteId);

        if (optionalQuote.isPresent()) {

            var quote = optionalQuote.get();

            return requestRepository.findByQuote(quote);

        } else {

            throw new RecordNotFoundException("no requests for quote");

        }

    }

    @Override
    public Request getRequest(Long id) {

        var optionalRequest = requestRepository.findById(id);

        if (optionalRequest.isEmpty()) {

            throw new RecordNotFoundException("no request was found");

        } else {

            return optionalRequest.get();

        }

    }

    @Override
    public void planRequest(Long machineId, Long jobId, Long quoteId, Long userDataId, LocalDateTime requestStartTime, LocalDateTime requestEndTime) {

        var optionalUserData = userDataRepository.findById(userDataId);

        var optionalMachine = machineRepository.findById(machineId);

        var optionalJob = jobRepository.findById(jobId);

        var optionalQuote = quoteRepository.findById(quoteId);


        if (optionalUserData.isEmpty() || (optionalMachine.isEmpty() && optionalJob.isEmpty() && optionalQuote.isEmpty())) {

            throw new BadRequestException("missing information");

        }


        var userData = optionalUserData.get();

        var machine = optionalMachine.get();

        var job = optionalJob.get();

        var quote = optionalQuote.get();


        if(machine != null) {

            validateRequestedSlotIsFreeMachine(requestStartTime, requestEndTime, machine);

        }

        var request = new Request();

        request.setUserData(userData);

        request.setMachine(machine);

        request.setJob(job);

        request.setQuote(quote);

        request.setRequestStartTime(requestStartTime);

        request.setRequestEndTime(requestEndTime);

        request.setStatus(RequestStatus.PLANNED);

        requestRepository.save(request);

    }

    private void validateRequestedSlotIsFreeMachine(LocalDateTime startTime, LocalDateTime endTime, Machine machine) {

        var overlappingStartRequests = requestRepository.findByRequestStartTimeBetweenAndMachine(startTime,
                endTime, machine);

        var overlappingEndRequests = requestRepository.findByRequestEndTimeBetweenAndMachine(startTime,
                endTime, machine);

        if (overlappingStartRequests.size() > 0 || overlappingEndRequests.size() > 0) {

            throw new BadRequestException();

        }

    }

    @Override
    public Request completeRequest(Long requestId, LocalDateTime actualStartTime, LocalDateTime actualEndTime) {

        var optionalRequest = requestRepository.findById(requestId);

        if (optionalRequest.isEmpty()) {

            throw new RecordNotFoundException("no request was found");

        }

        var request = optionalRequest.get();

        request.setConfirmedStartTime(actualStartTime);

        request.setConfirmedEndTime(actualEndTime);

        request.setStatus(RequestStatus.INVOICED);

        return requestRepository.save(request);

    }

    @Override
    public Request cancelRequest(Long requestId) {

        var optionalRequest = requestRepository.findById(requestId);

        if (optionalRequest.isEmpty()) {

            throw new RecordNotFoundException("no request was found");

        }

        var request = optionalRequest.get();

        request.setStatus(RequestStatus.CANCELED);

        return requestRepository.save(request);

    }

}
