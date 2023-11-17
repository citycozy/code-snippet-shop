package com.sku.codesnippetshop.domain.item.domain;

import com.sku.codesnippetshop.domain.Brand.domain.Brand;
import com.sku.codesnippetshop.domain.item.dto.ItemReadDto;
import com.sku.codesnippetshop.domain.item.dto.ItemCreateDto;
import com.sku.codesnippetshop.domain.item.dto.ItemUpdateDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
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

    private Long itemId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id", referencedColumnName = "brand_id")
    private Brand brand;


    @Column(name = "name",length = 30)
    private String name;


    @Column(name = "content")
    private String content;


    @Column(name = "rating")
    private BigDecimal rating;


    @Column(name = "review_count")
    private int reviewCount;


    @Column(name = "created_date")
    @CreatedDate
    private LocalDateTime regDt;


    @Column(name = "modified_date")
    @LastModifiedDate
    private LocalDateTime modDt;


    @Column(name = "quantity")
    private int quantity;

    @Builder
    private Item(String name, String content, int quantity, Brand brand) {
        this.name = name;
        this.content = content;
        this.rating = BigDecimal.ZERO;
        this.reviewCount = 0;
        this.quantity = quantity;
        this.brand = brand;
    }

    public void updateItem(ItemUpdateDto update) {
        this.name = update.getName();
        this.content = update.getContent();
        this.quantity = update.getQuantity();
    }

    public static ItemReadDto entityToDto(Item item) {
        return ItemReadDto.builder()
                .name(item.getName())
                .content(item.getContent())
                .rating(item.getRating())
                .reviewCount(item.getReviewCount())
                .regDt(item.getRegDt())
                .modDt(item.getModDt())
                .quantity(item.getQuantity())
                .build();
    }
    public static Item dtoToEntity(ItemCreateDto reg, Brand brand) {
        return Item.builder()
                .name(reg.getName())
                .content(reg.getContent())
                .quantity(reg.getQuantity())
                .brand(brand)
                .build();
    }
}
