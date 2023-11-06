package com.sku.codesnippetshop.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long fileId;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brandId;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item itemId;

    @Column(name = "file_name", columnDefinition = "TEXT")
    @NotNull
    private String fileName;
}
