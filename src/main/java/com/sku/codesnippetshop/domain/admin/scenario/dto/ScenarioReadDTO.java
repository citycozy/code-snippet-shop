package com.sku.codesnippetshop.domain.admin.scenario.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ScenarioReadDTO {
    private Long scenarioId;
    private String name;
    private Long logFormatId;
    private Long filterId;
    private String description;
    private Boolean topic_creation_enabled;
    private Long consumer_concurrency;
    private Boolean db_loaded;
    private Boolean hadoop_loaded;
    private Boolean status;
    private LocalDateTime regDt;
    private LocalDateTime modDt;
}
