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

        configureKeyForUniqueIdGenerationCounterInRedis(Constant.UNIQUE_ID_GENERATION_COUNTER_KEY);
        configureKeyForUniqueIdGenerationCounterInRedis(Constant.URL_SHORTENER_UNIQUE_ID_GENERATION_COUNTER_KEY);

        log.info("Unique ID generation keys are configured in Redis with value 0.");
    }

    @Override
    public String generateNumericUniqueId(String uniqueIdGenerationCounterKey) {

        long counter = getCounter(uniqueIdGenerationCounterKey);
        log.info("Unique ID generation counter for Key {} : {}", uniqueIdGenerationCounterKey, counter);

        return AppUtil.generateNumericUniqueId(counter);
    }

    @Override
    public String generateAlphanumericUniqueId(String uniqueIdGenerationCounterKey) {

        String numericUniqueId = generateNumericUniqueId(uniqueIdGenerationCounterKey);

        log.info("Numeric unique id for Key {} : {}", uniqueIdGenerationCounterKey, numericUniqueId);

        String alphanumericUniqueId = AppUtil.numericToAlphanumeric(numericUniqueId);

        log.info("Alphanumeric unique id for Key {} : {}", uniqueIdGenerationCounterKey, alphanumericUniqueId);

        return alphanumericUniqueId;
    }

    private Long getCounter(String uniqueIdGenerationCounterKey) {

        return redisTemplate.opsForValue().increment(uniqueIdGenerationCounterKey, 1);
    }

    private void configureKeyForUniqueIdGenerationCounterInRedis(String uniqueIdGenerationCounterKey) {

        redisTemplate.opsForValue().setIfAbsent(uniqueIdGenerationCounterKey, 0);
    }

}
