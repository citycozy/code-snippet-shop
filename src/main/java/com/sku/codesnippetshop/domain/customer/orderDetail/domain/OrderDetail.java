package com.sku.codesnippetshop.domain.customer.orderDetail.domain;

import com.sku.codesnippetshop.domain.customer.item.domain.Item;
import com.sku.codesnippetshop.domain.customer.order.domain.Order;
import com.sku.codesnippetshop.domain.customer.orderDetail.dto.OrderDetailCreateDTO;
import com.sku.codesnippetshop.domain.customer.orderDetail.dto.OrderDetailReadDTO;
import com.sku.codesnippetshop.domain.customer.review.domain.Review;
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

    @ManyToOne(fetch = FetchType.LAZY)
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
        OrderDetailReadDTO.OrderDetailReadDTOBuilder builder = OrderDetailReadDTO.builder()
                .orderDetailId(orderDetail.getOrderDetailId())
                .orderId(orderDetail.getOrder().getOrderId())
                .itemId(orderDetail.getItem().getItemId())
                .quantity(orderDetail.getQuantity());

        if(orderDetail.getReview()!=null)
            builder.reviewId(orderDetail.getReview().getReviewId());
        else
            builder.reviewId(null);

        return builder.build();
    }

    public static OrderDetail dtoToEntity(OrderDetailCreateDTO create, Order order, Item item){
        return OrderDetail.builder()
                .order(order)
                .item(item)
                .quantity(create.getQuantity())
                .build();
    }

    public void updateReview (Review review){
        this.review = review;
    }

}
