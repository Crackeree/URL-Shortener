package com.myworld.adamant.controller;

import com.myworld.adamant.core.service.UniqueIdGenerationService;
import com.myworld.adamant.util.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/generate")
@Slf4j
public class UniqueIdGenerationController {


    private final UniqueIdGenerationService uniqueIdGenerationService;

    public UniqueIdGenerationController(UniqueIdGenerationService uniqueIdGenerationService) {
        this.uniqueIdGenerationService = uniqueIdGenerationService;
    }

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public String generateUniqueId() {

        return uniqueIdGenerationService.generateNumericUniqueId(Constant.UNIQUE_ID_GENERATION_COUNTER_KEY);
    }
}

