package com.sku.codesnippetshop.domain.admin.scenario.domain;

import com.sku.codesnippetshop.domain.admin.key.domain.Key;
import com.sku.codesnippetshop.domain.admin.key.dto.KeyCreateDTO;
import com.sku.codesnippetshop.domain.admin.key.dto.KeyReadDTO;
import com.sku.codesnippetshop.domain.admin.key.dto.KeyUpdateDTO;
import com.sku.codesnippetshop.domain.admin.scenario.dto.ScenarioCreateDTO;
import com.sku.codesnippetshop.domain.admin.scenario.dto.ScenarioReadDTO;
import com.sku.codesnippetshop.domain.admin.scenario.dto.ScenarioUpdateDTO;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EntityListeners(AuditingEntityListener.class)
public class Scenario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "scenario_id")
    private Long scenarioId;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "log_format", length = 100)
    private String logFormat;

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
    private String status;

    @Column(name = "reg_dt")
    @CreatedDate
    private LocalDateTime regDt;

    @Column(name = "mod_dt")
    @LastModifiedDate
    private LocalDateTime modDt;

    @Builder
    public Scenario(Long scenarioId, String name, String logFormat, String description, String status) {
        this.scenarioId = scenarioId;
        this.name = name;
        this.logFormat = logFormat;
        this.description = description;
        this.topic_creation_enabled = false;
        this.consumer_concurrency = 0L;
        this.db_loaded = false;
        this.hadoop_loaded = false;
        this.status = "STOP";
    }

    public void updateScenario(ScenarioUpdateDTO update) {
        this.name = update.getName();
        this.description = update.getDescription();
        this.topic_creation_enabled = update.getTopic_creation_enabled();
        this.consumer_concurrency = update.getConsumer_concurrency();
        this.db_loaded = update.getDb_loaded();
        this.hadoop_loaded = update.getHadoop_loaded();
    }

    public static ScenarioReadDTO entityToDto(Scenario scenario){
        return ScenarioReadDTO.builder()
                .name(scenario.getName())
                .description(scenario.getDescription())
                .topic_creation_enabled(scenario.getTopic_creation_enabled())
                .consumer_concurrency(scenario.getConsumer_concurrency())
                .db_loaded(scenario.getDb_loaded())
                .hadoop_loaded(scenario.getHadoop_loaded())
                .logFormat(scenario.getLogFormat())
                .scenarioId(scenario.getScenarioId())
                .status(scenario.getStatus())
                .regDt(scenario.getRegDt())
                .modDt(scenario.getModDt())
                .build();
    }

    public static Scenario dtoToEntity(ScenarioCreateDTO create){
        return Scenario.builder()
                .name(create.getName())
                .logFormat(create.getLogFormat())
                .description(create.getDescription())
                .build();
    }
}
