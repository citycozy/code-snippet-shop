package com.sku.codesnippetshop.domain.Order.dto;

import com.sku.codesnippetshop.domain.Member.domain.Member;
import lombok.*;

import java.time.LocalDateTime;

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

}
