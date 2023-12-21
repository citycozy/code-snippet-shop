package com.sku.codesnippetshop.domain.admin.scenario.domain;

import com.sku.codesnippetshop.domain.admin.BaseEntity;
import com.sku.codesnippetshop.domain.admin.filter.domain.Filter;
import com.sku.codesnippetshop.domain.admin.logFormat.domain.LogFormat;
import com.sku.codesnippetshop.domain.admin.scenario.dto.ScenarioCreateDTO;
import com.sku.codesnippetshop.domain.admin.scenario.dto.ScenarioReadDTO;
import com.sku.codesnippetshop.domain.admin.scenario.dto.ScenarioUpdateDTO;
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
@AttributeOverride(
        name = "id",
        column =  @Column(name = "scenario_id")
)
public class Scenario extends BaseEntity {


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "log_format_id", referencedColumnName = "log_format_id")
    private LogFormat logFormatId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "filter_id", referencedColumnName = "filter_id")
    private Filter filterId;


    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "description", length = 100)
    private String description;

    @Column(name = "topic_creation_enabled")
    private Boolean topic_creation_enabled;

    @Column(name = "consumer_concurrency")
    private Long consumer_concurrency;

    @Column(name = "db_loaded")
    private Boolean db_loaded;

    @Column(name = "hadoop_loaded")
    private Boolean hadoop_loaded;

    @Column(name = "status")
    private Boolean status;


    @Builder
    public Scenario(Long scenarioId, String name, String description) {
        this.id = scenarioId;
        this.name = name;
        this.description = description;
        this.topic_creation_enabled = false;
        this.consumer_concurrency = 0L;
        this.db_loaded = false;
        this.hadoop_loaded = false;
        this.status = false;
    }

    public void updateScenario(ScenarioUpdateDTO update) {
        this.name = update.getName();
        this.description = update.getDescription();
        this.topic_creation_enabled = update.getTopic_creation_enabled();
        this.consumer_concurrency = update.getConsumer_concurrency();
        this.db_loaded = update.getDb_loaded();
        this.hadoop_loaded = update.getHadoop_loaded();
        this.status = update.getStatus();
    }

    public static ScenarioReadDTO entityToDto(Scenario scenario){
        return ScenarioReadDTO.builder()
                .name(scenario.getName())
                .description(scenario.getDescription())
                .topic_creation_enabled(scenario.getTopic_creation_enabled())
                .consumer_concurrency(scenario.getConsumer_concurrency())
                .db_loaded(scenario.getDb_loaded())
                .hadoop_loaded(scenario.getHadoop_loaded())
                .scenarioId(scenario.getId())
                .status(scenario.getStatus())
                .build();
    }

    public static Scenario dtoToEntity(ScenarioCreateDTO create){
        return Scenario.builder()
                .name(create.getName())
                .description(create.getDescription())
                .build();
    }
}
