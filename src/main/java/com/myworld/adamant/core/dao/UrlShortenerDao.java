package com.myworld.adamant.core.dao;

import com.myworld.adamant.core.domain.UrlEntity;

public interface UrlShortenerDao {

    UrlEntity save(UrlEntity urlEntity);

    UrlEntity findById(String id);
}
