package com.sku.codesnippetshop.domain.admin.keyScenarioAssociation.dto;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SCMapCreateDTO {
    private String option;
    private String input;
    private Long codeTableId;
    private Long scenarioId;
}
