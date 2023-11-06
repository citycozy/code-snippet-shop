package com.sku.codesnippetshop.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
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
    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item itemId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "review_id")
    private Review reviewId;

    @NotNull
    @Column(name = "quantity", columnDefinition = "int default 1")
    private int quantity;

}
