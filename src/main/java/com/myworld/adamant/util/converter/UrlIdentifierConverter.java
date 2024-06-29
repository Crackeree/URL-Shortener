package com.myworld.adamant.util.converter;

import com.myworld.adamant.core.enums.UrlIdentifierStatus;
import jakarta.persistence.AttributeConverter;

public class UrlIdentifierConverter implements AttributeConverter<UrlIdentifierStatus, String> {

    @Override
    public String convertToDatabaseColumn(UrlIdentifierStatus urlIdentifierStatus) {
        return urlIdentifierStatus.getValue();
    }

    @Override
    public UrlIdentifierStatus convertToEntityAttribute(String value) {

        return UrlIdentifierStatus.getUrlIdentifierStatus(value);
    }
}
