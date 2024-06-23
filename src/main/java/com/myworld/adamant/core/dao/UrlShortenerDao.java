package com.myworld.adamant.core.dao;

import com.myworld.adamant.core.domain.BaseEntity;

public interface UrlShortenerDao {

    void save(String tableName, BaseEntity baseEntity);
}
