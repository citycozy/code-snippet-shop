package com.sku.codesnippetshop.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    @NotNull
    private Long itemId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "brand_id")
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
    @CreationTimestamp
    private Timestamp createdDate;

    @NotNull
    @Column(name = "modified_date")
    @UpdateTimestamp
    private Timestamp modifiedDate;

    @NotNull
    @Column(name = "quantity")
    private int quantity;
}
