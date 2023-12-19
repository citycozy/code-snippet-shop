package com.sku.codesnippetshop.domain.customer.cart.dto;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CartUpdateDTO {

    private int quantity;
}
