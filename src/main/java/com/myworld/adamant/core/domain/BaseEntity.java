package com.myworld.adamant.core.domain;

import com.myworld.adamant.core.service.dto.UrlUniqueIdentifier;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TABLE_KEY", length = 1, nullable = false)
    private String tableKey;

    @Column(name = "CODE", length = 2, nullable = false)
    private String code;

    @Column(name = "URL_IN", length = 9, nullable = false, unique = true)
    private String urlIn;

    @Column(name = "URL", length = 200, nullable = false)
    private String url;


    public static BaseEntity from(UrlUniqueIdentifier urlUniqueIdentifier) {

        return BaseEntity.builder()
                .url(urlUniqueIdentifier.getUrl())
                .code(urlUniqueIdentifier.getCode())
                .tableKey(urlUniqueIdentifier.getTableKey())
                .urlIn(urlUniqueIdentifier.getUrlIn())
                .build();
    }


}
