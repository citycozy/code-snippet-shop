package com.sku.codesnippetshop.domain.customer.item.dto;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ItemReadIndexDto {

    private Long itemId;
    private String name;
    private String content;
    private String price;
}
