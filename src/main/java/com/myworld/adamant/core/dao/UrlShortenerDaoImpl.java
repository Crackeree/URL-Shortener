package com.myworld.adamant.core.dao;

import com.myworld.adamant.core.domain.BaseEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UrlShortenerDaoImpl implements UrlShortenerDao {

    @PersistenceContext
    private final EntityManager entityManager;

    public UrlShortenerDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(String tableName, BaseEntity baseEntity) {

        entityManager.persist(baseEntity);

        String sql = "INSERT INTO " + tableName + "(ID, TABLE_KEY, CODE, URL_IN, URL)" + " VALUES (?, ?, ?, ?, ?)";

        Query query = entityManager.createNativeQuery(sql);

        query.setParameter(1, baseEntity.getId());
        query.setParameter(2, baseEntity.getTableKey());
        query.setParameter(3, baseEntity.getCode());
        query.setParameter(4, baseEntity.getUrlIn());
        query.setParameter(5, baseEntity.getUrl());

        query.executeUpdate();

    }
}
