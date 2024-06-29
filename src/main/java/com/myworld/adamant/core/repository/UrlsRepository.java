package com.myworld.adamant.core.repository;

import com.myworld.adamant.core.domain.UrlIdentifierEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlsRepository  extends JpaRepository<UrlIdentifierEntity, String> {
}
