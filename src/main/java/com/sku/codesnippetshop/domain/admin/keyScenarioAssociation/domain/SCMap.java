package com.sku.codesnippetshop.domain.admin.keyScenarioAssociation.domain;

import com.sku.codesnippetshop.domain.admin.codeTable.domain.CodeTable;
import com.sku.codesnippetshop.domain.admin.keyScenarioAssociation.dto.SCMapCreateDTO;
import com.sku.codesnippetshop.domain.admin.keyScenarioAssociation.dto.SCMapReadDTO;
import com.sku.codesnippetshop.domain.admin.scenario.domain.Scenario;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EntityListeners(AuditingEntityListener.class)
public class SCMap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sc_map_id")
    private Long scMapId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "scenario_id", referencedColumnName = "scenario_id")
    private Scenario scenario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "code_table_id", referencedColumnName = "code_table_id")
    private CodeTable codeTable;

    @Column(name = "option")
    private String option;

    @Column(name = "input")
    private String input;


    @Builder
    private SCMap(Scenario scenario, CodeTable codeTable, String option, String input) {
        this.scenario = scenario;
        this.codeTable = codeTable;
        this.option = option;
        this.input = input;
    }



//    public void updateKey(SCMapUpdateDTO update) {
//        this.name = update.getName();
//        this.type = update.getType();
//        this.description = update.getDescription();
//    } // 살펴보기

    public static SCMapReadDTO entityToDto(SCMap scMap){
        return SCMapReadDTO.builder()
                .scMapId(scMap.getScMapId())
                .scenarioId(scMap.getScenario().getScenarioId())
                .codeTableId(scMap.getCodeTable().getCodeTableId())
                .option(scMap.getOption())
                .input(scMap.getInput())
                .build();
    }

    public static SCMap dtoToEntity(SCMapCreateDTO create, CodeTable codeTable, Scenario scenario){
        return SCMap.builder()
                .codeTable(codeTable)
                .scenario(scenario)
                .option(create.getOption())
                .input(create.getInput())
                .build();
    }


}
