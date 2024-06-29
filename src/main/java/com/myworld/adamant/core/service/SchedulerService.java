package com.myworld.adamant.core.service;

import com.myworld.adamant.core.config.ApplicationProperties;
import com.myworld.adamant.core.dao.UrlIdentifierDao;
import com.myworld.adamant.core.domain.UrlIdentifierEntity;
import com.myworld.adamant.core.enums.UrlIdentifierStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class SchedulerService {

    private final RedisTemplate<String, Object> redisTemplate;

    private final UrlIdentifierDao urlIdentifierDao;
    private final ApplicationProperties applicationProperties;

    public SchedulerService(RedisTemplate<String, Object> redisTemplate,
                            UrlIdentifierDao urlIdentifierDao, ApplicationProperties applicationProperties) {
        this.redisTemplate = redisTemplate;
        this.urlIdentifierDao = urlIdentifierDao;
        this.applicationProperties = applicationProperties;
    }


    @Scheduled(fixedRateString = "#{applicationProperties.identifierRecyclingInterval}")
    public void recycleUrlIdentifiers() {

        int identifierRecyclingBatchSize = applicationProperties.getIdentifierRecyclingBatchSize();

        Pageable pageable = PageRequest.of(0, identifierRecyclingBatchSize);

        List<UrlIdentifierEntity> entityList = urlIdentifierDao
                .findAllByStatusAndExpiresAtBefore(UrlIdentifierStatus.IN_USE, LocalDateTime.now(), pageable)
                .getContent()
                .stream()
                .peek(e -> e.setUrlIdentifierStatus(UrlIdentifierStatus.RECYCLED))
                .toList();

        urlIdentifierDao.saveAll(entityList);
    }
}
