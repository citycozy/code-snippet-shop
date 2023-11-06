package com.sku.codesnippetshop.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    @NotNull
    private Long orderId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member memberId;

    @NotNull
    @Column(name = "total_price")
    private int totalPrice;

    @NotNull
    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "delivery_request")
    private String deliveryRequest;

    @NotNull
    @Column(name = "create_date")
    @CreationTimestamp
    private Timestamp createDate;

    @NotNull
    @Column(name = "modify_date")
    @UpdateTimestamp
    private Timestamp modifyDate;

    @NotNull
    @Column(name = "status", columnDefinition = "default '정상'")
    private String status;

}
