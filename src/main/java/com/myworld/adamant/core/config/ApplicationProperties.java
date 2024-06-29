package com.myworld.adamant.core.config;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@Getter
public class ApplicationProperties {


    @Value("${scheduler.identifier.recycle.interval-in-millis}")
    private String identifierRecyclingInterval;


    @Value("${scheduler.identifier.recycle.batch-size}")
    private int identifierRecyclingBatchSize;


    @Value("${url.users.ttl-in-sec}")
    private int timeToLiveForUsersInSecs;
}
