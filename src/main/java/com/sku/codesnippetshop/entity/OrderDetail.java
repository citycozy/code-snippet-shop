package com.sku.codesnippetshop.entity;

import com.sku.codesnippetshop.domain.Order.domain.Order;
import com.sku.codesnippetshop.domain.item.domain.Item;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_detail_id")
    @NotNull
    private Long orderDetailId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order orderId;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id", referencedColumnName = "item_id")
    private Item itemId;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id", referencedColumnName = "review_id")
    private Review reviewId;

    @NotNull
    @Column(name = "quantity")
    private int quantity;
}
