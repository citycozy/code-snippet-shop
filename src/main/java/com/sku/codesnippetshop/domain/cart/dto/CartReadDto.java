package com.sku.codesnippetshop.domain.cart.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CartReadDto {

    private Long memberId;
    private Long itemId;
    private int quantity;
    private LocalDateTime regDt;
    private LocalDateTime modDt;

}
