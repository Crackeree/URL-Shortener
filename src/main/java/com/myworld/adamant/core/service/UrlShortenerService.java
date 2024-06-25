package com.myworld.adamant.core.service;

public interface UrlShortenerService {

    String shortenUrl(String url);

    String getUrl(String id);
}
