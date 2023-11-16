package com.sku.codesnippetshop.domain.item.domain;

import com.sku.codesnippetshop.domain.item.dto.ItemReadDto;
import com.sku.codesnippetshop.domain.item.dto.ItemRegDto;
import com.sku.codesnippetshop.domain.item.dto.ItemUpdateDto;
import com.sku.codesnippetshop.entity.Brand;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
    @Column(name = "rating")
    private BigDecimal rating;

    @NotNull
    @Column(name = "review_count")
    private int reviewCount;

    @NotNull
    @Column(name = "created_date")
    @CreatedDate
    private LocalDateTime regDt;

    @NotNull
    @Column(name = "modified_date")
    @LastModifiedDate
    private LocalDateTime modDt;

    @NotNull
    @Column(name = "quantity")
    private int quantity;

    @Builder
    private Item(String name, String content, int quantity) {
        this.name = name;
        this.content = content;
        this.rating = BigDecimal.ZERO;
        this.reviewCount = 0;
        this.quantity = quantity;
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
    public static Item dtoToEntity(ItemRegDto reg) {
        return Item.builder()
                .name(reg.getName())
                .content(reg.getContent())
                .quantity(reg.getQuantity())
                .build();
    }
}
