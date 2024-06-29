package com.myworld.adamant.core.enums;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public enum UrlIdentifierStatus {

    RECYCLED("00"),
    IN_USE("01");

    private final String value;
    private static final Map<String, UrlIdentifierStatus> map = new HashMap<>();

    static {

        for (UrlIdentifierStatus urlIdentifierStatus : UrlIdentifierStatus.values()) {

            map.put(urlIdentifierStatus.getValue(), urlIdentifierStatus);
        }
    }

    UrlIdentifierStatus(String value) {
        this.value = value;
    }

    public static UrlIdentifierStatus getUrlIdentifierStatus(String value) {

        UrlIdentifierStatus status = map.get(value);

        if (value == null || status == null) {
            throw new RuntimeException("Invalid Status");
        }

        return status;
    }


}
