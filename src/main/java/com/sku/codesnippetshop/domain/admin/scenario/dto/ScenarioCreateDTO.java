package com.sku.codesnippetshop.domain.admin.scenario.dto;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ScenarioCreateDTO {
    private String name;
    private String logFormat;
    private String description;
    private Boolean topic_creation_enabled;
    private Long consumer_concurrency;
    private Boolean db_loaded;
    private Boolean hadoop_loaded;

}
