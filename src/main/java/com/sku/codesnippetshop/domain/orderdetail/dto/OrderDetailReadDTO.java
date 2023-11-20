package com.sku.codesnippetshop.domain.orderdetail.dto;

import com.sku.codesnippetshop.domain.item.domain.Item;
import com.sku.codesnippetshop.domain.order.domain.Order;
import com.sku.codesnippetshop.entity.Review;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
