package com.sku.codesnippetshop.domain.file.domain;


import com.sku.codesnippetshop.domain.brand.domain.Brand;
import com.sku.codesnippetshop.domain.item.domain.Item;
import jakarta.persistence.*;
import lombok.*;

@Entity
@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FileData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id", referencedColumnName = "brand_id")
    private Brand brand;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id", referencedColumnName = "item_id")
    private Item item;

    @Column(name = "file_name")
    private String fileName;

    @Column(name ="file_path")
    private String filePath;
    @Builder
    private FileData(String fileName, String filePath, Item item, Brand brand) {
        this.fileName = fileName;
        this.filePath = filePath;
        this.item = item;
        this.brand = brand;
    }
}
