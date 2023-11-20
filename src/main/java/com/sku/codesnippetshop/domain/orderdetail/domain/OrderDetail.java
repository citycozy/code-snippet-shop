package com.sku.codesnippetshop.domain.orderdetail.domain;

import com.sku.codesnippetshop.domain.order.domain.Order;
import com.sku.codesnippetshop.domain.item.domain.Item;
import com.sku.codesnippetshop.domain.orderdetail.dto.OrderDetailCreateDTO;
import com.sku.codesnippetshop.domain.orderdetail.dto.OrderDetailReadDTO;
import com.sku.codesnippetshop.entity.Review;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_detail_id")
    private Long orderDetailId;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id", referencedColumnName = "item_id")
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id", referencedColumnName = "review_id")
    private Review review;

    @Column(name = "quantity")
    private int quantity;

    @Builder
    private OrderDetail(Order order, Item item, Review review, int quantity) {
        this.order = order;
        this.item = item;
        this.review = review;
        this.quantity = quantity;
    }

    public static OrderDetailReadDTO entityToDTO(OrderDetail orderDetail) {
        return OrderDetailReadDTO.builder()
                .orderId(orderDetail.getOrder().getOrderId())
                .itemId(orderDetail.getItem().getItemId())
                .reviewId(orderDetail.getReview().getReviewId())
                .quantity(orderDetail.getQuantity())
                .build();
    }

    public static OrderDetail dtoToEntity(OrderDetailCreateDTO create, Order order, Item item, Review review){
        return OrderDetail.builder()
                .order(order)
                .item(item)
                .review(review)
                .quantity(create.getQuantity())
                .build();
    }


}
