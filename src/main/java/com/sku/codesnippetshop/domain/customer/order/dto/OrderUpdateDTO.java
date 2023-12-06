package com.sku.codesnippetshop.domain.customer.order.dto;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderUpdateDTO {
    private String deliveryRequest;
    private String status;

}
