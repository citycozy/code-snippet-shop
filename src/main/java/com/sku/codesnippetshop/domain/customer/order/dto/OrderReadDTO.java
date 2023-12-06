package com.sku.codesnippetshop.domain.customer.order.dto;

import com.sku.codesnippetshop.domain.customer.orderDetail.dto.OrderDetailReadDTO;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderReadDTO {

    private Long memberId;
    private int totalPrice;
    private String paymentMethod;
    private String deliveryRequest;
    private LocalDateTime regDt;
    private LocalDateTime modDt;
    private String status;

    private List<OrderDetailReadDTO> orderDetailReadDTOList;
}
