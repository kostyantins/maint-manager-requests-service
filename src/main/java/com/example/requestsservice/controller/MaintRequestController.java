package com.example.requestsservice.controller;

import com.example.requestsservice.domain.MaintRequests;
import com.example.requestsservice.repository.MaintRequestsRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping("/requests")
@RequiredArgsConstructor
public class MaintRequestController {

    private final MaintRequestsRepository maintRequestsRepository;

    private static int DELAY = 500;

    @SneakyThrows
    @GetMapping
    public ResponseEntity<MaintRequests> getMaintRequests(@RequestParam Long requestsId) {
        //to test circuitBreaker
        log.info("Waiting {}ms", DELAY);
        Thread.sleep(DELAY += 100);
        log.info("Responding with error");

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(maintRequestsRepository.findById(requestsId).orElseThrow());
    }

    @PostMapping
    public ResponseEntity<MaintRequests> createMaintRequests(@RequestBody MaintRequests maintRequests) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(maintRequestsRepository.save(maintRequests));
    }
}
