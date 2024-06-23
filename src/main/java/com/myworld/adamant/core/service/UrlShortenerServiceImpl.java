package com.myworld.adamant.core.service;

import com.myworld.adamant.core.dao.UrlShortenerDao;
import com.myworld.adamant.core.domain.BaseEntity;
import com.myworld.adamant.core.service.dto.UrlUniqueIdentifier;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.myworld.adamant.util.Constant.URL_SHORTENER_UNIQUE_ID_GENERATION_COUNTER_KEY;

@Service
@Slf4j
public class UrlShortenerServiceImpl implements UrlShortenerService {

    private final UniqueIdGenerationService uniqueIdGenerationService;
    private final UrlShortenerDao urlShortenerDao;

    public UrlShortenerServiceImpl(UniqueIdGenerationService uniqueIdGenerationService,
                                   UrlShortenerDao urlShortenerDao) {
        this.uniqueIdGenerationService = uniqueIdGenerationService;
        this.urlShortenerDao = urlShortenerDao;
    }

    @Override
    public String shortenUrl(String url) {

        String uniqueId = uniqueIdGenerationService
                .generateAlphanumericUniqueId(URL_SHORTENER_UNIQUE_ID_GENERATION_COUNTER_KEY);

        UrlUniqueIdentifier urlUniqueIdentifier = UrlUniqueIdentifier.from(uniqueId, url);

        BaseEntity baseEntity = BaseEntity.from(urlUniqueIdentifier);

        String tableName = (urlUniqueIdentifier.getTableKey().matches("^[0-9a-z]$")) ?
                "_".concat(urlUniqueIdentifier.getTableKey()) : "__".concat(urlUniqueIdentifier.getTableKey());


        log.info("Saving URL to Database: {}", tableName);
        urlShortenerDao.save(tableName, baseEntity);
        log.info("Saved URL to Database: {}", tableName);

        return uniqueId;
    }
}
