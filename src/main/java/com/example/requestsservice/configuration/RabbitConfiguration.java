package com.example.requestsservice.configuration;

import com.example.requestsservice.domain.MaintUpdateEvent;
import com.example.requestsservice.service.MaintClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Log4j2
@Configuration
@RequiredArgsConstructor
public class RabbitConfiguration {

    private final MaintClientService maintClientService;

    //There are three ways to work with events:
    //1. Listening - using Consumer
    //2. Gating, processing and creating new onw - using Function
    //3. Generating an event - using Supplier
    @Bean
    public Consumer<MaintUpdateEvent> maintUpdateEventConsumer() {
        return event -> {
            log.info("Received a maint event {}", event);
            maintClientService.synchronizeRequestById(event.maintId());
        };
    }
}
