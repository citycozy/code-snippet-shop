package com.sku.codesnippetshop.domain.customer.item.dto;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ItemCreateDto {

    private String name;
    private Long brandId;
    private String content;
    private int quantity;
}
