package com.myworld.adamant.core.dao;

import com.myworld.adamant.core.domain.UrlEntity;
import com.myworld.adamant.core.service.dto.UrlUniqueIdentifier;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
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
    public void save(String tableName, UrlEntity urlEntity) {

        entityManager.persist(urlEntity);

        String sql = "INSERT INTO " + tableName + " (ID, TABLE_KEY, CODE, URL_IN, URL) " + " VALUES (?, ?, ?, ?, ?)";

        Query query = entityManager.createNativeQuery(sql);

        query.setParameter(1, urlEntity.getId());
        query.setParameter(2, urlEntity.getTableKey());
        query.setParameter(3, urlEntity.getCode());
        query.setParameter(4, urlEntity.getUrlIn());
        query.setParameter(5, urlEntity.getUrl());

        query.executeUpdate();

    }

    @Override
    @Transactional
    public UrlEntity findByIdentifier(String tableName, UrlUniqueIdentifier identifier) {

        String jpql = """
                 SELECT e FROM UrlEntity e WHERE e.code = :code AND e.urlIn = :urlIn \
                """;

        TypedQuery<UrlEntity> query = entityManager.createQuery(jpql, UrlEntity.class);

        query.setParameter("code", identifier.getCode());
        query.setParameter("urlIn", identifier.getUrlIn());
        query.setMaxResults(1);

        return query.getResultList().stream().findFirst()
                .orElseThrow(() -> new RuntimeException("Invalid Identifier. "));
    }
}
