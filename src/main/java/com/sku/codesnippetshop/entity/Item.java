package com.sku.codesnippetshop.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EntityListeners(AuditingEntityListener.class)
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    @NotNull
    private Long itemId;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id", referencedColumnName = "brand_id")
    private Brand brandId;

    @NotNull
    @Column(name = "name",length = 30)
    private String name;

    @NotNull
    @Column(name = "content")
    private String content;

    @NotNull
    @Column(name = "rating", columnDefinition = "decimal(2,1) default 0.0")
    private BigDecimal rating;

    @NotNull
    @Column(name = "review_count", columnDefinition = "int default 0")
    private int reviewCount;

    @NotNull
    @Column(name = "created_date")
    @CreatedDate
    private LocalDateTime createdDate;

    @NotNull
    @Column(name = "modified_date")
    @LastModifiedDate
    private LocalDateTime modifiedDate;

    @NotNull
    @Column(name = "quantity")
    private int quantity;
}
