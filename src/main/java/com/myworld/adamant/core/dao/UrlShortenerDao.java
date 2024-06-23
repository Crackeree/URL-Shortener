package com.myworld.adamant.core.dao;

import com.myworld.adamant.core.domain.UrlEntity;
import com.myworld.adamant.core.service.dto.UrlUniqueIdentifier;

public interface UrlShortenerDao {

    void save(String tableName, UrlEntity urlEntity);

    UrlEntity findByIdentifier(String tableName, UrlUniqueIdentifier identifier);
}
