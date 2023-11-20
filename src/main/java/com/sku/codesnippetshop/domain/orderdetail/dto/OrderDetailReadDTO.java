package com.sku.codesnippetshop.domain.orderdetail.dto;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderDetailReadDTO {

    private Long orderDetailId;

    private Long orderId;

    private Long itemId;

    private Long reviewId;

    private int quantity;
}
