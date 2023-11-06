package com.sku.codesnippetshop.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
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
    @CreationTimestamp
    private Timestamp createdDate;

    @NotNull
    @Column(name = "modified_date")
    @UpdateTimestamp
    private Timestamp modifiedDate;
}
