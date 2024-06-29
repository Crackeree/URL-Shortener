package com.myworld.adamant.core.dao;

import com.myworld.adamant.core.domain.UrlIdentifierEntity;
import com.myworld.adamant.core.enums.UrlIdentifierStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;

public interface UrlIdentifierDao {

    UrlIdentifierEntity save(UrlIdentifierEntity urlIdentifierEntity);

    UrlIdentifierEntity findById(String id);

    UrlIdentifierEntity findEntityInUseById(String id);

    Page<UrlIdentifierEntity> findAllByStatusAndExpiresAtBefore(UrlIdentifierStatus urlIdentifierStatus,
                                                                LocalDateTime expiresAt,
                                                                Pageable pageable);

    void saveAll(List<UrlIdentifierEntity> urlIdentifierEntities);
}
