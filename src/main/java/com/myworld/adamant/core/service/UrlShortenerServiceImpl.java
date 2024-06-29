package com.myworld.adamant.core.service;

import com.myworld.adamant.core.config.ApplicationProperties;
import com.myworld.adamant.core.dao.UrlIdentifierDao;
import com.myworld.adamant.core.domain.UrlIdentifierEntity;
import com.myworld.adamant.util.AppUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.myworld.adamant.util.Constant.URL_SHORTENER_UNIQUE_ID_GENERATION_COUNTER_KEY;

@Service
@Slf4j
public class UrlShortenerServiceImpl implements UrlShortenerService {

    private final UniqueIdGenerationService uniqueIdGenerationService;
    private final UrlIdentifierDao urlIdentifierDao;
    private final ApplicationProperties applicationProperties;

    public UrlShortenerServiceImpl(UniqueIdGenerationService uniqueIdGenerationService,
                                   UrlIdentifierDao urlIdentifierDao,
                                   ApplicationProperties applicationProperties) {
        this.uniqueIdGenerationService = uniqueIdGenerationService;
        this.urlIdentifierDao = urlIdentifierDao;
        this.applicationProperties = applicationProperties;
    }

    @Override
    public String shortenUrl(String url) {

        String uniqueId = generateUniqueId();

        int timeToLiveInSecs = applicationProperties.getTimeToLiveForUsersInSecs();

        UrlIdentifierEntity urlIdentifierEntity = UrlIdentifierEntity.of(uniqueId, url, timeToLiveInSecs);

        urlIdentifierDao.save(urlIdentifierEntity);

        return AppUtil.buildShortUrl(uniqueId);
    }

    private String generateUniqueId() {

        return uniqueIdGenerationService.generateAlphanumericUniqueId(URL_SHORTENER_UNIQUE_ID_GENERATION_COUNTER_KEY);
    }

    @Override
    public String getUrl(String id) {

        return urlIdentifierDao.findEntityInUseById(id)
                .getUrl();
    }
}
