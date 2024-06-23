package com.myworld.adamant.core.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UrlUniqueIdentifier {

    private String tableKey;

    private String code;

    private String urlIn;

    public static UrlUniqueIdentifier from(String uniqueId) {

        return UrlUniqueIdentifier.builder()
                .tableKey(uniqueId.substring(0, 1))
                .code(uniqueId.substring(1, 3))
                .urlIn(uniqueId.substring(3))
                .build();
    }

    public String getTableName() {

        return (tableKey.matches("^[0-9a-z]$")) ?
                "_".concat(tableKey) : "__".concat(tableKey);
    }
}
