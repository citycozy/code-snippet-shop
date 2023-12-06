package com.sku.codesnippetshop.domain.admin.scenario.domain;

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

    @Column(name = "reg_dt")
    @CreatedDate
    private LocalDateTime regDt;

    @Column(name = "mod_dt")
    @LastModifiedDate
    private LocalDateTime modDt;

    @Builder
    public Scenario(Long scenarioId, String name, String logFormat, String description, Boolean topic_creation_enabled, Long consumer_concurrency, Boolean db_loaded, Boolean hadoop_loaded) {
        this.scenarioId = scenarioId;
        this.name = name;
        this.logFormat = logFormat;
        this.description = description;
        this.topic_creation_enabled = topic_creation_enabled;
        this.consumer_concurrency = consumer_concurrency;
        this.db_loaded = db_loaded;
        this.hadoop_loaded = hadoop_loaded;
    }


}
