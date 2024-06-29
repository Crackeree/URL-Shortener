package com.myworld.adamant.core.domain;

import com.myworld.adamant.core.enums.UrlIdentifierStatus;
import com.myworld.adamant.util.converter.UrlIdentifierConverter;
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
@Table(name = "url_identifier")
public class UrlIdentifierEntity {

    @Id
    @Column(name = "id", length = 12, nullable = false)
    private String id;

    @Column(name = "URL", length = 200, nullable = false)
    private String url;

    @Column(name = "STATUS", length = 2, nullable = false)
    @Convert(converter = UrlIdentifierConverter.class)
    private UrlIdentifierStatus urlIdentifierStatus;


    public static UrlIdentifierEntity of(String uniqueId, String url) {

        return UrlIdentifierEntity.builder()
                .id(uniqueId)
                .url(url)
                .urlIdentifierStatus(UrlIdentifierStatus.IN_USE)
                .build();
    }
}
