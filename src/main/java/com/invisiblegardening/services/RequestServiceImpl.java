package com.invisiblegardening.services;

import com.invisiblegardening.Exceptions.BadRequestException;
import com.invisiblegardening.Exceptions.RecordNotFoundException;
import com.invisiblegardening.Models.*;
import com.invisiblegardening.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@Service
public class RequestServiceImpl implements RequestService,RequestJobService, RequestMachineService {
    private RequestRepository requestRepository;
    private UserDataRepository userDataRepository;
    private RequestMachineRepository requestMachineRepository;
    private MachineRepository machineRepository;
    private RequestJobRepository requestJobRepository;
    private JobRepository jobRepository;


    @Autowired
    public RequestServiceImpl(RequestRepository requestRepository,

                              UserDataRepository userDataRepository,

                              MachineRepository machineRepository,

                              RequestMachineRepository requestMachineRepository,

                              JobRepository jobRepository,

                              RequestJobRepository requestJobRepository){

        this.requestRepository = requestRepository;

        this.userDataRepository = userDataRepository;

        this.machineRepository = machineRepository;

        this.requestMachineRepository = requestMachineRepository;

        this.jobRepository = jobRepository;

        this.requestJobRepository = requestJobRepository;

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
    public void planRequest(Collection<Long> machineIdList, Collection<Long> jobIdList, Long userDataId, LocalDateTime requestStartTime, LocalDateTime requestEndTime) {

        var optionalUserData = userDataRepository.findById(userDataId);

        var userData = optionalUserData.get();

        var request = new Request();

        request.setUserData(userData);

        var requestSize = (long)requestRepository.findAll().size();

        request.setId(requestSize + 1);

        request.setRequestStartTime(requestStartTime);

        request.setRequestEndTime(requestEndTime);

        request.setStatus(RequestStatus.PLANNED);

        requestRepository.save(request);

        var requestId = request.getId();

        for (Long machineId : machineIdList) {

            addRequestMachine(requestId, machineId);

        }

        request.setRequestMachines(requestMachineRepository.findAllByRequestId(requestId));

        for (Long jobId : jobIdList) {

            addRequestJob(requestId, jobId);
        }

        if (optionalUserData.isEmpty() || (machineIdList.isEmpty() && jobIdList.isEmpty() )) {

            throw new BadRequestException("missing information");

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

    @Override
    public Collection<RequestMachine> getAllMachineResults() {
        Collection<RequestMachine> requestMachines = requestMachineRepository.findAll();
        return requestMachines;
    }

    @Override
    public Collection<Machine> getRequestMachinesByRequestId(long requestId) {
        Collection<Machine> machines = new HashSet<>();
        Collection<RequestMachine> requestMachines = requestMachineRepository.findAllByRequestId(requestId);
        for (RequestMachine requestmachine : requestMachines) {
            machines.add(requestmachine.getMachine());
        }
        return machines;
    }

    @Override
    public Collection<Request> getRequestMachinesByMachineId(long machineId) {
        Collection<Request> requests = new HashSet<>();
        Collection<RequestMachine> requestMachines = requestMachineRepository.findAllByRequestId(machineId);
        for (RequestMachine requestMachine : requestMachines) {
            requests.add(requestMachine.getRequest());
        }
        return requests;
    }

    @Override
    public RequestMachine getRequestMachineById(long requestId, long machineId) {
        return requestMachineRepository.findById(new RequestMachineKey(requestId, machineId)).orElse(null);    }

    @Override
    public RequestMachineKey addRequestMachine(long requestId, long machineId) {
        var requestMachine = new RequestMachine();
        if (!machineRepository.existsById(machineId)) { throw new RecordNotFoundException(); }
        Machine machine = machineRepository.findById(machineId).orElse(null);
        if (!requestRepository.existsById(requestId)) { throw new RecordNotFoundException(); }
        Request request = requestRepository.findById(requestId).orElse(null);
        requestMachine.setMachine(machine);
        requestMachine.setRequest(request);
        RequestMachineKey id = new RequestMachineKey(machineId, requestId);
        requestMachine.setId(id);
        requestMachineRepository.save(requestMachine);
        return id;
    }

    @Override
    public Collection<RequestJob> getAllJobResults() {
        Collection<RequestJob> requestJobs = requestJobRepository.findAll();
        return requestJobs;
    }

    @Override
    public Collection<Job> getRequestJobsByRequestId(long requestId) {
        Collection<Job> jobs = new HashSet<>();
        Collection<RequestJob> requestJobs = requestJobRepository.findAllByRequestId(requestId);
        for (RequestJob requestJob : requestJobs) {
            jobs.add(requestJob.getJob());
        }
        return jobs;
    }

    @Override
    public Collection<Request> getRequestJobsByJobId(long jobId) {
        Collection<Request> requests = new HashSet<>();
        Collection<RequestJob> requestJobs = requestJobRepository.findAllByRequestId(jobId);
        for (RequestJob requestJob : requestJobs) {
            requests.add(requestJob.getRequest());
        }
        return requests;
    }

    @Override
    public RequestJob getRequestJobById(long requestId, long jobId) {
        return requestJobRepository.findById(new RequestJobKey(requestId, requestId)).orElse(null);
    }

    @Override
    public RequestJobKey addRequestJob(long requestId, long jobId) {
        var requestJob = new RequestJob();
        if (!jobRepository.existsById(jobId)) { throw new RecordNotFoundException(); }
        Job job = jobRepository.findById(jobId).orElse(null);
        if (!requestRepository.existsById(requestId)) { throw new RecordNotFoundException(); }
        Request request = requestRepository.findById(requestId).orElse(null);
        requestJob.setJob(job);
        requestJob.setRequest(request);
        RequestJobKey id = new RequestJobKey(jobId, requestId);
        requestJob.setId(id);
        requestJobRepository.save(requestJob);
        return id;
    }
}
