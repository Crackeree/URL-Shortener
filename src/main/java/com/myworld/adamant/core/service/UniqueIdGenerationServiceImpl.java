package com.myworld.adamant.core.service;

import com.myworld.adamant.util.AppUtil;
import com.myworld.adamant.util.Constant;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class UniqueIdGenerationServiceImpl implements UniqueIdGenerationService {

    private final RedisTemplate<String, Object> redisTemplate;

    public UniqueIdGenerationServiceImpl(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    public void init() {

        configureUniqueIdGenerationCounterKeyInRedis();
        log.info("Unique ID generation key is configured in Redis with value 0");
    }

    @Override
    public String generateUniqueId() {

        long counter = getCounter();
        log.info("Unique ID generation counter: {}", counter);

        return AppUtil.generateUniqueId(counter);
    }

    private Long getCounter() {

        return redisTemplate.opsForValue().increment(Constant.UNIQUE_ID_GENERATION_COUNTER_KEY, 1);
    }

    private void configureUniqueIdGenerationCounterKeyInRedis() {

       redisTemplate.opsForValue().setIfAbsent(Constant.UNIQUE_ID_GENERATION_COUNTER_KEY, 0);
    }

}
