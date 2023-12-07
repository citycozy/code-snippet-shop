package com.sku.codesnippetshop.domain.cart.dto;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CartCreateDto {

    private Long memberId;
    private Long itemId;
    private int quantity;
}
