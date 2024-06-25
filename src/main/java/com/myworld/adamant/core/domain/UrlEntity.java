package com.myworld.adamant.core.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "urls")
public class UrlEntity {

    @Id
    @Column(name = "id", length = 12, nullable = false)
    private String id;

    @Column(name = "URL", length = 200, nullable = false)
    private String url;

    public static UrlEntity of(String uniqueId, String url) {

        return UrlEntity.builder()
                .id(uniqueId)
                .url(url)
                .build();
    }
}
