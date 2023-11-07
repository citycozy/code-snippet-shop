package com.sku.codesnippetshop.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
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
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand_id")
    @NotNull
    private Long brandId;

    @NotNull
    @Column(name = "name",length = 30)
    private String name;

    @NotNull
    @Column(name = "created_date")
    @CreatedDate
    private LocalDateTime createdDate;

    @NotNull
    @Column(name = "modified_date")
    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
