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


}
