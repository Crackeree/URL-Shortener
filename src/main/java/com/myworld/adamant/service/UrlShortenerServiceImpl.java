package com.myworld.adamant.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UrlShortenerServiceImpl implements UrlShortenerService {

    private final CryptoOperation cryptoOperation;

    public UrlShortenerServiceImpl(CryptoOperation cryptoOperation) {
        this.cryptoOperation = cryptoOperation;
    }

    @Override
    public String shortenUrl(String url) {

        return cryptoOperation.hash(url);
    }
}
