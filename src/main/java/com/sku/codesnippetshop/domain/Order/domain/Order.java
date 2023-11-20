package com.sku.codesnippetshop.domain.Order.domain;

import com.sku.codesnippetshop.domain.Member.domain.Member;
import com.sku.codesnippetshop.domain.Order.dto.OrderCreateDTO;
import com.sku.codesnippetshop.domain.Order.dto.OrderReadDTO;
import com.sku.codesnippetshop.domain.Order.dto.OrderUpdateDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EntityListeners(AuditingEntityListener.class)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", referencedColumnName = "member_id")
    private Member member;


    @Column(name = "total_price")
    private int totalPrice;


    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "delivery_request")
    private String deliveryRequest;


    @Column(name = "status")
    private String status;

    @Column(name = "create_date")
    @CreatedDate
    private LocalDateTime createDate;

    @Column(name = "modify_date")
    @LastModifiedDate
    private LocalDateTime modifyDate;




    @Builder
    private Order(Member member, int totalPrice, String paymentMethod, String deliveryRequest, String status) {
        this.member = member;
        this.totalPrice = totalPrice;
        this.paymentMethod = paymentMethod;
        this.deliveryRequest = deliveryRequest;
        this.status = "주문 확인 중";
    }

    public void updateOrder(OrderUpdateDTO update) {
        this.deliveryRequest = update.getDeliveryRequest();
        this.status = update.getStatus();
    }

    public static OrderReadDTO entityToDTO(Order order) {
        return OrderReadDTO.builder()
                .memberId(order.getMember().getMemberId())
                .totalPrice(order.getTotalPrice())
                .paymentMethod(order.getPaymentMethod())
                .deliveryRequest(order.getDeliveryRequest())
                .status(order.getStatus())
                .regDt(order.getCreateDate())
                .modDt(order.getModifyDate())
                .build();
    }

    public static Order dtoToEntity(OrderCreateDTO create, Member member){
        return Order.builder()
                .member(member)
                .totalPrice(create.getTotalPrice())
                .paymentMethod(create.getPaymentMethod())
                .deliveryRequest(create.getDeliveryRequest())
                .status(create.getStatus())
                .build();
    }

}
