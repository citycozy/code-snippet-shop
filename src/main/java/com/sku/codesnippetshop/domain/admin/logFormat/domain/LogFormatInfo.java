package com.sku.codesnippetshop.domain.admin.logFormat.domain;

import com.sku.codesnippetshop.domain.admin.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EntityListeners(AuditingEntityListener.class)
@Table(name = "log_format_info")
@AttributeOverride(
        name = "id",
        column = @Column(name = "log_format_info_id")
)
public class LogFormatInfo extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "log_format_id", referencedColumnName = "log_format_id")
    private LogFormat logFormat;

    @Column(name = "data")
    private String data;

    @Column(name = "seq")
    private String seq;
}