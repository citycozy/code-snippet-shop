package com.sku.codesnippetshop.domain.admin.scenario.dto;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ScenarioCreateDTO {
    private Long filterId;
    private Long logFormatId;
    private String name;
    private String description;

}
