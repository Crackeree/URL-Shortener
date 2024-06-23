package com.myworld.adamant.controller;

import com.myworld.adamant.controller.payload.UrlShortenerRequest;
import com.myworld.adamant.core.service.UrlShortenerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/shorten")
@Slf4j
public class UrlShortenerController {

    private final UrlShortenerService urlShortenerService;

    public UrlShortenerController(UrlShortenerService urlShortenerService) {
        this.urlShortenerService = urlShortenerService;
    }

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public String shortenUrl(@RequestBody UrlShortenerRequest request) {

        log.info("URL: {}", request.getUrl());
        return urlShortenerService.shortenUrl(request.getUrl());
    }
}

