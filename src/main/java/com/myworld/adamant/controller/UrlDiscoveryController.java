package com.myworld.adamant.controller;

import com.myworld.adamant.core.service.UrlShortenerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
@Slf4j
public class UrlDiscoveryController {

    private final UrlShortenerService urlShortenerService;

    public UrlDiscoveryController(UrlShortenerService urlShortenerService) {
        this.urlShortenerService = urlShortenerService;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getUrl(@PathVariable("id") String uniqueId) {

        log.info("ID: {}", uniqueId);
        return urlShortenerService.getUrl(uniqueId);
    }
}

