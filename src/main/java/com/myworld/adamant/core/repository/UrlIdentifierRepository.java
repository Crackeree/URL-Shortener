package com.myworld.adamant.core.repository;

import com.myworld.adamant.core.domain.UrlIdentifierEntity;
import com.myworld.adamant.core.enums.UrlIdentifierStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface UrlIdentifierRepository extends JpaRepository<UrlIdentifierEntity, String> {

    Page<UrlIdentifierEntity> findByUrlIdentifierStatusAndExpiresAtBefore(UrlIdentifierStatus urlIdentifierStatus,
                                                                    LocalDateTime expiresAt,
                                                                    Pageable pageable);
}
