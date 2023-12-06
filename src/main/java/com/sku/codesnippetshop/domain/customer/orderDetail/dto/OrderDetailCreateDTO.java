package com.sku.codesnippetshop.domain.customer.orderDetail.dto;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderDetailCreateDTO {
    private Long itemId;
    private Long reviewId;
    private int quantity;
}
