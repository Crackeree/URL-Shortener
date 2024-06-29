package com.myworld.adamant.core.dao;

import com.myworld.adamant.core.domain.UrlIdentifierEntity;
import com.myworld.adamant.core.enums.UrlIdentifierStatus;
import com.myworld.adamant.core.repository.UrlIdentifierRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@Slf4j
public class UrlIdentifierDaoImpl implements UrlIdentifierDao {


    private final UrlIdentifierRepository urlIdentifierRepository;

    public UrlIdentifierDaoImpl(UrlIdentifierRepository urlIdentifierRepository) {
        this.urlIdentifierRepository = urlIdentifierRepository;
    }

    @Override
    public UrlIdentifierEntity save(UrlIdentifierEntity urlIdentifierEntity) {
        return urlIdentifierRepository.save(urlIdentifierEntity);
    }

    @Override
    public UrlIdentifierEntity findById(String id) {

        return urlIdentifierRepository.findById(id).orElseThrow(
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

    @Override
    public Page<UrlIdentifierEntity> findAllByStatusAndExpiresAtBefore(UrlIdentifierStatus urlIdentifierStatus,
                                                                       LocalDateTime dateTime,
                                                                       Pageable pageable) {

        return urlIdentifierRepository.findByUrlIdentifierStatusAndExpiresAtBefore(urlIdentifierStatus,
                dateTime,
                pageable);
    }

    @Override
    public void saveAll(List<UrlIdentifierEntity> urlIdentifierEntities) {

        urlIdentifierRepository.saveAll(urlIdentifierEntities);
    }


}
