package com.example.requestsservice.feigns;

import com.example.requestsservice.domain.MaintCopy;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "maints")
public interface MaintRequestFeign {

    @GetMapping("{maintId}")
    MaintCopy getMaintCopy(@PathVariable Long maintId);
}
