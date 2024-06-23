package com.myworld.adamant.core.service;

import com.myworld.adamant.core.dao.UrlShortenerDao;
import com.myworld.adamant.core.domain.UrlEntity;
import com.myworld.adamant.core.service.dto.UrlUniqueIdentifier;
import com.myworld.adamant.util.AppUtil;
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

        UrlUniqueIdentifier urlUniqueIdentifier = UrlUniqueIdentifier.from(uniqueId);

        UrlEntity urlEntity = UrlEntity.from(urlUniqueIdentifier, url);

        String tableName = urlUniqueIdentifier.getTableName();

        log.info("Saving URL to Database: {}", tableName);
        urlShortenerDao.save(tableName, urlEntity);
        log.info("Saved URL to Database: {}", tableName);

        return AppUtil.buildShortUrl(uniqueId);
    }

    @Override
    public String getUrl(String uniqueId) {

        UrlUniqueIdentifier urlUniqueIdentifier = UrlUniqueIdentifier.from(uniqueId);
        String tableName = urlUniqueIdentifier.getTableName();
        UrlEntity urlEntity = urlShortenerDao.findByIdentifier(tableName, urlUniqueIdentifier);
        return urlEntity.getUrl();
    }
}
