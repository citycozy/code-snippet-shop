package com.sku.codesnippetshop.domain.customer.item.dto;


import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ItemReadDto {
    private Long brandId;
    private String name;
    private String content;
    private BigDecimal rating;
    private int reviewCount;
    private LocalDateTime regDt;
    private LocalDateTime modDt;
    private int quantity;
}
