package com.sku.codesnippetshop.domain.admin.logFormat.domain;


import com.sku.codesnippetshop.domain.admin.BaseEntity;
import com.sku.codesnippetshop.domain.admin.key.domain.Key;
import com.sku.codesnippetshop.domain.admin.logFormat.dto.LogFormat.LogFormatCreateDTO;
import com.sku.codesnippetshop.domain.admin.logFormat.dto.LogFormat.LogFormatReadDTO;
import com.sku.codesnippetshop.domain.admin.logFormat.dto.LogFormatKeyMap.CreateDTO;
import com.sku.codesnippetshop.domain.admin.logFormat.dto.LogFormatKeyMap.ReadDTO;
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
@Table(name = "log_format_key_map")
@AttributeOverride(
        name = "id",
        column =  @Column(name = "log_format_key_map_id")
)

public class LogFormatKeyMap extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "key_id", referencedColumnName = "key_id")
    private Key key;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "log_format_id", referencedColumnName = "log_format_id")
    private LogFormat logFormat;

    @Builder
    private LogFormatKeyMap(Key key,  LogFormat logFormat) {
        this.key = key;
        this.logFormat = logFormat;
    }

    public static ReadDTO entityToDto(LogFormatKeyMap logFormatKeyMap){
        return ReadDTO.builder()
                .logFormatId(logFormatKeyMap.getLogFormat().getId())
                .logFormatKeyMapId(logFormatKeyMap.getId())
                .keyId(logFormatKeyMap.getKey().getId())
                .regDt(logFormatKeyMap.getRegDt())
                .modDt(logFormatKeyMap.getModDt())
                .build();
    }

    public static LogFormatKeyMap dtoToEntity(Key key, LogFormat logFormat){
        return LogFormatKeyMap.builder()
                .key(key)
                .logFormat(logFormat)
                .build();
    }
}
