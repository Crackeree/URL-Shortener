package com.myworld.adamant.core.dao;

import com.myworld.adamant.core.domain.UrlIdentifierEntity;

public interface UrlShortenerDao {

    UrlIdentifierEntity save(UrlIdentifierEntity urlIdentifierEntity);

    UrlIdentifierEntity findById(String id);

    UrlIdentifierEntity findEntityInUseById(String id);
}
