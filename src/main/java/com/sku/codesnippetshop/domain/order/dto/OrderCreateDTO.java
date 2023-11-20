package com.sku.codesnippetshop.domain.order.dto;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderCreateDTO {
    private Long memberId;
    private int totalPrice;
    private String paymentMethod;
    private String deliveryRequest;
    private String status;
}
