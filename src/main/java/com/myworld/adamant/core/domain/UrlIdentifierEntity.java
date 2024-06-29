package com.myworld.adamant.core.domain;

import com.myworld.adamant.core.enums.UrlIdentifierStatus;
import com.myworld.adamant.util.converter.UrlIdentifierConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "url_identifier")
public class UrlIdentifierEntity extends BaseDomain {

    @Id
    @Column(name = "id", length = 12, nullable = false)
    private String id;

    @Column(name = "URL", length = 200, nullable = false)
    private String url;

    @Column(name = "STATUS", length = 2, nullable = false)
    @Convert(converter = UrlIdentifierConverter.class)
    private UrlIdentifierStatus urlIdentifierStatus;

    @Column(name = "EXPIRES_AT", nullable = false)
    private LocalDateTime expiresAt;

    public static UrlIdentifierEntity of(String uniqueId, String url, int timeToLiveInSecs) {

        return UrlIdentifierEntity.builder()
                .id(uniqueId)
                .url(url)
                .urlIdentifierStatus(UrlIdentifierStatus.IN_USE)
                .expiresAt(LocalDateTime.now().plusSeconds(timeToLiveInSecs))
                .build();
    }
}
