package com.sku.codesnippetshop.domain.admin.logFormat.domain;

import com.sku.codesnippetshop.domain.admin.BaseEntity;
import com.sku.codesnippetshop.domain.admin.logFormat.dto.LogFormat.LogFormatCreateDTO;
import com.sku.codesnippetshop.domain.admin.logFormat.dto.LogFormat.LogFormatReadDTO;
import com.sku.codesnippetshop.domain.admin.logFormat.dto.LogFormat.LogFormatUpdateDTO;
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
@Table(name = "log_format")
@AttributeOverride(
        name = "id",
        column = @Column(name = "log_format_id")
)
public class LogFormat extends BaseEntity {


    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "description", length = 100)
    private String description;

    @Builder
    private LogFormat(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public void updateLogFormat(LogFormatUpdateDTO update) {
        this.name = update.getName();
        this.description = update.getDescription();
    } // 살펴보기

    public static LogFormatReadDTO entityToDto(LogFormat logFormat){
        return LogFormatReadDTO.builder()
                .logFormatId(logFormat.getId())
                .name(logFormat.getName())
                .description(logFormat.getDescription())
                .regDt(logFormat.getRegDt())
                .modDt(logFormat.getModDt())
                .build();
    }

    public static LogFormat dtoToEntity(LogFormatCreateDTO create){
        return LogFormat.builder()
                .name(create.getName())
                .description(create.getDescription())
                .build();
    }


}
