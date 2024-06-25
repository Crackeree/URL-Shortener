package com.myworld.adamant.core.service;

import com.myworld.adamant.core.dao.UrlShortenerDao;
import com.myworld.adamant.core.domain.UrlEntity;
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

        UrlEntity urlEntity = UrlEntity.of(uniqueId, url);

        urlShortenerDao.save(urlEntity);

        return AppUtil.buildShortUrl(uniqueId);
    }

    @Override
    public String getUrl(String id) {

        return urlShortenerDao.findById(id).getUrl();
    }
}
