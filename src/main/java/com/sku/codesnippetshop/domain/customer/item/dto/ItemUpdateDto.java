package com.sku.codesnippetshop.domain.customer.item.dto;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ItemUpdateDto {

    private String name;
    private String content;
    private int quantity;
    private String price;
}
