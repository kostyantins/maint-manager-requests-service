package com.example.requestsservice.repository;

import com.example.requestsservice.domain.MaintRequests;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaintRequestsRepository extends JpaRepository<MaintRequests, Long> {

}
