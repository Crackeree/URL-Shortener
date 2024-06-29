package com.myworld.adamant.core.dao;

import com.myworld.adamant.core.domain.UrlIdentifierEntity;
import com.myworld.adamant.core.enums.UrlIdentifierStatus;
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
    public UrlIdentifierEntity save(UrlIdentifierEntity urlIdentifierEntity) {
        return urlsRepository.save(urlIdentifierEntity);
    }

    @Override
    public UrlIdentifierEntity findById(String id) {

        return urlsRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Url not found"));
    }

    @Override
    public UrlIdentifierEntity findEntityInUseById(String id) {

        UrlIdentifierEntity urlIdentifier = findById(id);

        if (urlIdentifier.getUrlIdentifierStatus() != UrlIdentifierStatus.IN_USE) {
            throw new RuntimeException("Url identifier is not in use");
        }
        return urlIdentifier;
    }
}
