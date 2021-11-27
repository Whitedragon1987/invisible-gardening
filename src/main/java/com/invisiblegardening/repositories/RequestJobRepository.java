package com.invisiblegardening.repositories;

import com.invisiblegardening.Models.RequestJob;
import com.invisiblegardening.Models.RequestJobKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface RequestJobRepository extends JpaRepository<RequestJob, RequestJobKey> {

    Collection<RequestJob> findAllByRequestId(Long requestId);

}
