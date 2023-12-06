package com.sku.codesnippetshop.domain.customer.order.dto;

import com.sku.codesnippetshop.domain.customer.orderDetail.dto.OrderDetailCreateDTO;
import lombok.*;

import java.util.List;

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
    private List<OrderDetailCreateDTO> orderDetails;
}
