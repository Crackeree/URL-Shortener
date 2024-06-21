package com.myworld.adamant.service;

import com.myworld.adamant.util.AppUtil;
import com.myworld.adamant.util.Constant;
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

    @Override
    public String generateUniqueId() {

        long counter = getCounter();

        log.info("Trace counter: {}", counter);
        return AppUtil.generateUniqueId(counter);
    }

    private Long getCounter() {

        if (!hasKey()) {
            log.info("No such key found in redis. Hence {} is being set with value 1", Constant.UNIQUE_ID_GENERATION_COUNTER_KEY);
            return 1L;
        }

        log.info("Key {} found in redis.", Constant.UNIQUE_ID_GENERATION_COUNTER_KEY);
        return redisTemplate.opsForValue().increment(Constant.UNIQUE_ID_GENERATION_COUNTER_KEY, 1);

    }

    private boolean hasKey() {

        Boolean isKeyAbsent = redisTemplate.opsForValue().setIfAbsent(Constant.UNIQUE_ID_GENERATION_COUNTER_KEY, 1);

        return Boolean.FALSE.equals(isKeyAbsent);
    }

}
