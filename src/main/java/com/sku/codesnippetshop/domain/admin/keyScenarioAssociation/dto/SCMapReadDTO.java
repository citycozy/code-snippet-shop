package com.sku.codesnippetshop.domain.admin.keyScenarioAssociation.dto;

import com.sku.codesnippetshop.domain.admin.codeTable.domain.CodeTable;
import com.sku.codesnippetshop.domain.admin.scenario.domain.Scenario;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SCMapReadDTO {
    private Long scMapId;
    private Long scenarioId;
    private Long codeTableId;
    private String option;
    private String input;
}
