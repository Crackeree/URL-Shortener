package com.myworld.adamant.core.dao;

import com.myworld.adamant.core.domain.UrlEntity;
import com.myworld.adamant.core.repository.UrlsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UrlShortenerDaoImpl implements UrlShortenerDao {


    private final UrlsRepository urlsRepository;

    public UrlShortenerDaoImpl(UrlsRepository urlsRepository) {
        this.urlsRepository = urlsRepository;
    }

    @Override
    public UrlEntity save(UrlEntity urlEntity) {
        return urlsRepository.save(urlEntity);
    }

    @Override
    public UrlEntity findById(String id) {

        return urlsRepository.findById(id).orElseThrow(() -> new RuntimeException("Url not found"));
    }
}
